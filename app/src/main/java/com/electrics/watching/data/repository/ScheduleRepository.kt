package com.electrics.watching.data.repository

import android.util.Log
import androidx.datastore.preferences.protobuf.Timestamp
import com.electrics.watching.data.local.dao.ScheduleDao
import com.electrics.watching.data.mapper.ScheduleEntityMapper
import com.electrics.watching.data.mapper.ScheduleResponseMapper
import com.electrics.watching.data.prefs.AppPrefsStorage
import com.electrics.watching.data.remote.api.ScheduleApi
import com.electrics.watching.data.utils.Result2
import com.electrics.watching.data.utils.execute
import com.electrics.watching.data.utils.toResult
import com.electrics.watching.domain.models.ScheduleItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import javax.inject.Inject

class ScheduleRepository @Inject constructor(
    private val scheduleApi: ScheduleApi,
    private val scheduleResponseMapper: ScheduleResponseMapper,
    private val scheduleEntityMapper: ScheduleEntityMapper,
    private val scheduleDao: ScheduleDao,
    private val appPrefsStorage: AppPrefsStorage
) {

    suspend fun getSchedule(): Flow<List<ScheduleItem>> = flow {
        val localItems = scheduleDao.select().map { scheduleEntityMapper.map(it) }
        emit(localItems)
        if (isNeedScheduleUpdate()) {
            when (val result = execute { scheduleApi.getSchedule().toResult() }) {
                is Result2.Failed -> {
                    Log.e(
                        "ScheduleRepository",
                        result.throwable.message ?: "Get remote schedule error"
                    )
                }
                is Result2.Success -> {
                    scheduleDao.deleteAll()
                    val remoteItems = result.data
                        ?.mapNotNull { scheduleResponseMapper.map(it) }
                        ?: emptyList()
                    val remoteEntities = remoteItems.map { scheduleEntityMapper.map(it) }
                    scheduleDao.insert(remoteEntities)
                    appPrefsStorage.setLastScheduleUpdate(Timestamp.getDefaultInstance().seconds)
                    emit(remoteItems)
                }
            }
        }
    }

    private suspend fun isNeedScheduleUpdate(): Boolean {
        val lastUpdateTime = appPrefsStorage.schedulePreferences.last().lastUpdate.seconds
        val currentTime = Timestamp.getDefaultInstance().seconds
        return currentTime >= lastUpdateTime + UPDATE_TIME
    }

    companion object {
        /**
         * Временной промежуток обновления даных
         */
        const val UPDATE_TIME = 60 * 60 * 24
    }
}
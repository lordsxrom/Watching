package com.electrics.watching.data.prefs

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.protobuf.Timestamp
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPrefsStorage @Inject constructor(
    @ApplicationContext private val applicationContext: Context
) {

    private val Context.dataStore by preferencesDataStore(name = USER_PREFERENCES_NAME)

    val schedulePreferences: Flow<SchedulePreferences> = applicationContext.dataStore.data
        .map { preferences ->
            val lastUpdate = Timestamp.newBuilder()
                .setSeconds(
                    preferences[LAST_SCHEDULE_UPDATE]
                        ?: Timestamp.getDefaultInstance().seconds
                )
                .build()
            SchedulePreferences(lastUpdate)
        }


    suspend fun setLastScheduleUpdate(value: Long) {
        applicationContext.dataStore.edit {
            it[LAST_SCHEDULE_UPDATE] = value
        }
    }

    companion object {
        private const val USER_PREFERENCES_NAME = "user_preferences"
        private val LAST_SCHEDULE_UPDATE = longPreferencesKey("last_schedule_update")
    }

}
package com.electrics.watching.presentation.screens.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.electrics.watching.data.utils.Result2
import com.electrics.watching.domain.models.SearchItem
import com.electrics.watching.domain.use_case.FullScheduleUseCase
import com.electrics.watching.domain.use_case.SearchShowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchShowUseCase: SearchShowUseCase,
    private val fullScheduleUseCase: FullScheduleUseCase
) : ViewModel() {

    val query = MutableLiveData("")

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    var searchList = MutableLiveData<List<SearchItem>>()

    private val _error = MutableSharedFlow<String>()
    val error: SharedFlow<String> = _error

    fun searchShow(q: String) {
        viewModelScope.launch {
            _isLoading.value = true
            when (val result = searchShowUseCase(q)) {
                is Result2.Success -> {
                    _isLoading.value = false
                    searchList.value = result.data
                    Log.d("SearchViewModel", result.data.toString())
                }
                is Result2.Failed -> {
                    _isLoading.value = false
                    val errorMessage = result.throwable.message ?: "error"
                    _error.emit(errorMessage)
                    Log.e("SearchViewModel", errorMessage)
                }
            }
        }
    }

    fun getSchedule() {
        viewModelScope.launch {
            _isLoading.value = true
            fullScheduleUseCase().collect { scheduleItems ->
                _isLoading.value = false
                Log.d("SearchViewModel", scheduleItems.toString())
            }
        }
    }

    // Функция, которая будет открывать подробную информацию
    fun click(search: SearchItem) {
        Log.d("kekpek", "${search.score} ${search.show.name} ${search.show.summary}")
    }
}
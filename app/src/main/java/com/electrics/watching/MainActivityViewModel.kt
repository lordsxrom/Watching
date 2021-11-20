package com.electrics.watching

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.electrics.watching.data.utils.Result2
import com.electrics.watching.domain.use_case.SearchShowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val searchShowUseCase: SearchShowUseCase
) : ViewModel() {

    fun searchShow(q: String) {
        viewModelScope.launch {
            when (val result = searchShowUseCase.invoke(q)) {
                is Result2.Success -> {
                    Log.d("MainActivityViewModel", result.data.items.toString())
                }
                is Result2.Failed -> {
                    Log.e("MainActivityViewModel", result.throwable.message ?: "error")
                }
            }
        }
    }

}
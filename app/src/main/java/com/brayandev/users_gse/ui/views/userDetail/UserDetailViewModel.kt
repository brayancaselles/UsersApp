package com.brayandev.users_gse.ui.views.userDetail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brayandev.users_gse.domain.useCase.RequestUserDetailUseCase
import com.brayandev.users_gse.ui.views.navigation.USER_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.Delegates

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    useCase: RequestUserDetailUseCase,
) : ViewModel() {

    private var userId by Delegates.notNull<Int>()

    private val _state = mutableStateOf(UserDetailUiState())
    val state: MutableState<UserDetailUiState> = _state

    init {

        userId = savedStateHandle[USER_ID] ?: 0

        viewModelScope.launch {
            _state.value = UserDetailUiState(isLoading = true)
            delay(2000)
            val user = useCase.invoke(userId)
            _state.value = UserDetailUiState(isLoading = false, user)
        }
    }
}

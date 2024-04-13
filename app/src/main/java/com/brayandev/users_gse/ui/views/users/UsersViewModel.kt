package com.brayandev.users_gse.ui.views.users

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brayandev.users_gse.domain.model.UserItemModel
import com.brayandev.users_gse.domain.useCase.RequestUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(useCase: RequestUsersUseCase) : ViewModel() {

    private val _state = mutableStateOf(UserUiState())
    val state: MutableState<UserUiState> = _state

    init {
        viewModelScope.launch {
            _state.value = UserUiState(isLoading = true)
            delay(2000)
            val users: List<UserItemModel> = useCase.invoke()

            _state.value = UserUiState(isLoading = false, users)
        }
    }
}

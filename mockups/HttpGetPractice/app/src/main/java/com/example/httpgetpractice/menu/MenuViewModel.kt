package com.example.httpgetpractice.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.httpgetpractice.model.Menu
import kotlinx.coroutines.launch

class MenuViewModel(
    private val coordinator: MenuCoordinator,
    private val useCase: MenuUseCase
) : ViewModel() {
    private val _menuList = MutableLiveData<MutableList<Menu>>()
    val menuList: LiveData<MutableList<Menu>> get() = _menuList

    fun fetchMenuData() {
        viewModelScope.launch {
            _menuList.value = useCase.fetchMenuData()
            println(_menuList.value)
        }
    }
}
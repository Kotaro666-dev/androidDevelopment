package com.example.httpgetpractice.menu

import com.example.httpgetpractice.model.Menu
import com.example.httpgetpractice.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MenuUseCase(
    private val repository: Repository
) {
    suspend fun fetchMenuData(): MutableList<Menu> {
        var menuList: MutableList<Menu>
        withContext(Dispatchers.IO) {
            menuList = repository.fetchMenuData()
        }
        return menuList
    }
}
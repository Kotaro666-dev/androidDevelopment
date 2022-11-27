package com.example.mercariinjetpackcompose.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomePageViewModel : ViewModel() {
    private val _categories = MutableLiveData<MutableList<String>>(mutableListOf())
    val categories: LiveData<MutableList<String>> = _categories

    private val _initialPage = MutableLiveData(0)
    val initialPage: LiveData<Int> = _initialPage

    init {
        viewModelScope.launch {
            launch { initializeCategories() }.join()
            setInitialPageValue()
        }
    }

    private fun setInitialPageValue() {
        _initialPage.value = _categories.value?.size!! / 2 + 2
    }

    private fun initializeCategories() {
        viewModelScope.launch(Dispatchers.Default) {
            val categoryMembers = mutableListOf("おすすめ", "ショップ", "保存した検索条件")
            for (index in 0..100) {
                if (index == 0) {
                    _categories.postValue(categoryMembers)
                } else {
                    val currentCategories = _categories.value
                    currentCategories!! += categoryMembers
                    _categories.postValue(currentCategories)
                }
            }
        }
    }
}
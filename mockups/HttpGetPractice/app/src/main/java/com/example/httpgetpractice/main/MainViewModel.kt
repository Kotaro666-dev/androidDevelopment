package com.example.httpgetpractice.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.httpgetpractice.model.CustomerInfo
import kotlinx.coroutines.launch

class MainViewModel(
    private val coordinator: MainCoordinator,
    private val useCase: MainUseCase
) : ViewModel() {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _accountNumber = MutableLiveData<String>()
    val accountNumber: LiveData<String> = _accountNumber

    private val _loginStatus = MutableLiveData<String>()
    val loginStatus: LiveData<String> = _loginStatus

    private val _depositAmount = MutableLiveData<String>()
    val depositAmount: LiveData<String> = _depositAmount

    fun fetchCustomerInfo() {
        viewModelScope.launch {
            useCase.fetchCustomerInfo()
        }
    }

    fun displayCustomerInfo() {
        viewModelScope.launch {
            val customerInfo = useCase.displayCustomerInfo()
            if (customerInfo != null) {
                updateLiveData(customerInfo)
            }
        }
    }

    private fun getLoginStatus(isLoggedIn: Boolean): String {
        return if (isLoggedIn) {
            "オン"
        } else {
            "オフ"
        }
    }

    private fun updateLiveData(customerInfo: CustomerInfo) {
        _name.value = customerInfo.name
        _accountNumber.value = customerInfo.accountNumber
        _loginStatus.value = getLoginStatus(customerInfo.isLoggedIn)
        _depositAmount.value = customerInfo.depositNumber.toString()
    }
}
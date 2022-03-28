package com.example.mercariinjetpackcompose.views.notification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercariinjetpackcompose.model.NotificationMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NotificationPageViewModel : ViewModel() {
    private val _notifications = MutableLiveData<MutableList<NotificationMessage>>(mutableListOf())
    val notifications: LiveData<MutableList<NotificationMessage>> = _notifications

    init {
        viewModelScope.launch {
            fetchNotifications()
        }
    }

    private suspend fun fetchNotifications() {
        withContext(Dispatchers.IO) {
            _notifications.postValue(getStubNotifications())
        }
    }

    private fun getStubNotifications(): MutableList<NotificationMessage> {
        val result = mutableListOf<NotificationMessage>()
        for (index in 0..50) {
            when (index % 3) {
                0 -> result.add(
                    NotificationMessage(
                        "https://via.placeholder.com/120",
                        "1日前",
                        "この週末がラストチャンス！1分間に466子売れている！今なら売上金3倍のチャンス！"
                    )
                )
                1 -> result.add(
                    NotificationMessage(
                        "https://via.placeholder.com/120",
                        "2日前",
                        "【まもなく終了！】最大P300必ずもらえる！出品するなら今"
                    )
                )
                2 -> result.add(
                    NotificationMessage(
                        "https://via.placeholder.com/120",
                        "3日前",
                        "招待した人もされた人もP500必ずもらえる！"
                    )
                )
            }
        }
        return result
    }
}
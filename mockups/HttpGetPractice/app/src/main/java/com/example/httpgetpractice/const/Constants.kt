package com.example.httpgetpractice.const

class Constants {
    companion object {
        private const val LOCALHOST_IP_ADDRESS = "192.168.11.10"
        const val URL = "http://$LOCALHOST_IP_ADDRESS:8080"
    }
}
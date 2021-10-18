package com.mkt120.settingnotification.top

interface Contract {
    interface View {
        fun createNotification()
    }
    interface Presenter {
        fun onCreate()
    }
}
package com.mkt120.settingnotification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import androidx.core.app.NotificationManagerCompat

class SettingNotificationApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val channel = NotificationChannel(
            Const.NOTIFICATION_CHANNEL_ID,
            getString(R.string.notification_channel_name),
            NotificationManager.IMPORTANCE_DEFAULT
        )
        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.createNotificationChannel(channel)
    }
}
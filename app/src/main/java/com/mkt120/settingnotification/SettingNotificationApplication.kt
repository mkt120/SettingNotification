package com.mkt120.settingnotification

import android.app.Application
import android.app.NotificationManager
import android.os.Build
import com.mkt120.settingnotification.util.NotificationUtil

class SettingNotificationApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            NotificationUtil.createChannel(
                this,
                Const.NOTIFICATION_CHANNEL_ID,
                getString(R.string.notification_channel_name),
                "",
                NotificationManager.IMPORTANCE_DEFAULT
            )
        }
    }
}
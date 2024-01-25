package com.mkt120.settingnotification.view.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.mkt120.settingnotification.domain.Setting
import com.mkt120.settingnotification.util.NotificationUtil
import com.mkt120.settingnotification.util.PreferenceUtil
import com.mkt120.settingnotification.view.MainActivity

class DeleteNotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        intent ?: return
        context ?: return

        when (intent.getIntExtra(NotificationUtil.EXTRA_INT_NOTIFICATION_ID, -1)) {
            Setting.Time.notificationId -> {
                PreferenceUtil.setShowTime(context, false)
                NotificationUtil.hideNotification(context, Setting.Time.notificationId)
            }
            Setting.DeviceInfo.notificationId -> {
                PreferenceUtil.setShowDeviceInfo(context, false)
                NotificationUtil.hideNotification(context, Setting.DeviceInfo.notificationId)
            }
            Setting.Display.notificationId -> {
                PreferenceUtil.setShowDisplay(context, false)
                NotificationUtil.hideNotification(context, Setting.Display.notificationId)
            }
            Setting.BatterySave.notificationId -> {
                PreferenceUtil.setShowBatterySave(context, false)
                NotificationUtil.hideNotification(context, Setting.BatterySave.notificationId)
            }
            Setting.Developer.notificationId -> {
                PreferenceUtil.setShowDeveloper(context, false)
                NotificationUtil.hideNotification(context, Setting.Developer.notificationId)
            }
            Setting.Setting.notificationId -> {
                PreferenceUtil.setShowSetting(context, false)
                NotificationUtil.hideNotification(context, Setting.Setting.notificationId)
            }
            else -> {
                // アプリ
            }
        }
        context.sendBroadcast(intent.apply {
            setClass(context, MainActivity::class.java)
        })
    }
}
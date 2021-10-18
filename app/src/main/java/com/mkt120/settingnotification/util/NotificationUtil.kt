package com.mkt120.settingnotification.util

import android.app.NotificationChannel
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.mkt120.settingnotification.Const
import com.mkt120.settingnotification.R

object NotificationUtil {

    fun createChannel(
        context: Context,
        channelId: String,
        name: String,
        description: String,
        importance: Int
    ) {
        val channel = NotificationChannel(
            channelId,
            name,
            importance
        )
        channel.description = description
        NotificationManagerCompat.from(context).createNotificationChannel(channel)
    }

    fun deleteChannel(
        context: Context,
        channelId: String
    ) {
        NotificationManagerCompat.from(context).deleteNotificationChannel(channelId)
    }

    fun showNotification(
        context: Context,
        channelId: String = Const.NOTIFICATION_CHANNEL_ID,
        titleResId: Int,
        priority: Int = NotificationCompat.PRIORITY_HIGH,
        pendingIntent: PendingIntent,
        onGoing: Boolean = true,
        notificationId: Int,
        smallIcon: Int = R.mipmap.ic_launcher,
    ) {
        showNotification(
            context,
            channelId,
            notificationId,
            context.getString(titleResId),
            priority,
            pendingIntent,
            onGoing,
            smallIcon
        )
    }

    private fun showNotification(
        context: Context,
        channelId: String,
        notificationId: Int,
        title: String,
        priority: Int,
        pendingIntent: PendingIntent,
        onGoing: Boolean,
        smallIcon: Int
    ) {
        val notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(smallIcon)
            .setContentIntent(pendingIntent)
            .setContentTitle(title)
            .setPriority(priority)
            .setGroup(title)
            .setContentIntent(pendingIntent)
            .setOngoing(onGoing)
            .build()

        NotificationManagerCompat.from(context).notify(notificationId, notification)
    }

    fun hideNotification(
        context: Context,
        notificationId: Int
    ) {
        NotificationManagerCompat.from(context).cancel(notificationId)
    }

    fun createNotificationChannelIntent(channelId: String? = null): Intent {
        return Intent().apply {
            if (channelId != null) {
                action = Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS
                putExtra(Settings.EXTRA_CHANNEL_ID, channelId)
            } else {
                action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
            }
        }
    }
}
package com.mkt120.settingnotification.util

import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.graphics.drawable.IconCompat
import androidx.core.os.bundleOf
import com.mkt120.settingnotification.Const
import com.mkt120.settingnotification.R
import com.mkt120.settingnotification.view.receiver.DeleteNotificationReceiver

object NotificationUtil {

    @TargetApi(Build.VERSION_CODES.O)
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

    fun showNotification(
        context: Context,
        channelId: String = Const.NOTIFICATION_CHANNEL_ID,
        notificationId: Int,
        title: String,
        priority: Int = NotificationCompat.PRIORITY_HIGH,
        pendingIntent: PendingIntent,
        onGoing: Boolean = true,
        smallIconResId: Int = R.mipmap.ic_launcher,
        deleteNotificationBundle: Bundle = bundleOf(EXTRA_INT_NOTIFICATION_ID to notificationId),
    ) {
        val intent = Intent(context, DeleteNotificationReceiver::class.java).apply {
            action = ACTION_DELETE_NOTIFICATION
            putExtras(deleteNotificationBundle)
        }
        val notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(smallIconResId)
            .setContentIntent(pendingIntent)
            .setContentTitle(title)
            .setPriority(priority)
            .setGroup(title)
            .setContentIntent(pendingIntent)
            .setOngoing(onGoing)
            .addAction(NotificationCompat.Action(null, "非表示にする", PendingIntent.getBroadcast(context, notificationId, intent, PendingIntent.FLAG_IMMUTABLE)))
            .build()

        NotificationManagerCompat.from(context).notify(notificationId, notification)
    }

    fun hideNotification(
        context: Context,
        notificationId: Int
    ) {
        NotificationManagerCompat.from(context).cancel(notificationId)
    }

    const val ACTION_DELETE_NOTIFICATION = "com.mkt120.settingnotification.action_delete_notification"
    const val EXTRA_INT_NOTIFICATION_ID = "extra_notification_id"
    const val EXTRA_STR_PACKAGE_NAME = "extra_package_name"
}
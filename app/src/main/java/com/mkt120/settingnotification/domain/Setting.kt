package com.mkt120.settingnotification.domain

import android.content.Intent
import android.provider.Settings
import com.mkt120.settingnotification.R

/**
 * @property textResId: タイトルのリソースID
 * @property smallIconResId: アイコンリソースID
 * @property intent: Notification タップのPendingIntentとして利用するIntent
 * @property packageName : アプリのPackageName
 * @property text: アプリ名
 * @property notificationId: 通知ID
 */
class Setting(
    val textResId: Int = 0,
    val smallIconResId: Int = R.drawable.ic_baseline_settings_24,
    val intent: Intent? = null,
    val packageName : String? = null,
    val text: String? = null,
    val notificationId: Int = textResId
) {
    companion object {
        val Time = Setting(
            R.string.device_date_setting,
            R.drawable.ic_baseline_access_time_24,
            Intent(Settings.ACTION_DATE_SETTINGS)
        )
        val DeviceInfo = Setting(
            R.string.device_info_setting,
            R.drawable.ic_baseline_device_information_24,
            Intent(Settings.ACTION_DEVICE_INFO_SETTINGS)
        )

        val Display = Setting(
            R.string.device_display_setting,
            R.drawable.ic_baseline_phone_android_24,
            Intent(Settings.ACTION_DISPLAY_SETTINGS)
        )
        val BatterySave = Setting(
            R.string.battery_save_setting,
            R.drawable.ic_baseline_battery_24,
            Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS)
        )
        val Developer = Setting(
            R.string.development_setting,
            R.drawable.ic_baseline_developer_mode_24,
            Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
        )
        val Setting = Setting(
            R.string.device_setting,
            R.drawable.ic_baseline_settings_24,
            Intent(Settings.ACTION_SETTINGS)
        )
    }
}
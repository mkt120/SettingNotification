package com.mkt120.settingnotification.top

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.app.NotificationCompat
import com.mkt120.settingnotification.R
import com.mkt120.settingnotification.top.appList.AppListActivity
import com.mkt120.settingnotification.util.NotificationUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 端末時刻
        findViewById<View>(R.id.device_date_setting).setOnClickListener {
            findViewById<SwitchCompat>(R.id.device_date_setting_switch).let { switch ->
                switch.isChecked = if (switch.isChecked) {
                    hideDateSettingNotification()
                    !switch.isChecked
                } else {
                    showDateSettingNotification()
                    !switch.isChecked
                }

            }
        }

        // バッテリーセーバー
        findViewById<View>(R.id.battery_saver_setting).setOnClickListener {
            findViewById<SwitchCompat>(R.id.battery_saver_setting_switch).let { switch ->
                switch.isChecked = if (switch.isChecked) {
                    hideDataSaverNotification()
                    !switch.isChecked
                } else {
                    showDataSaverNotification()
                    !switch.isChecked
                }

            }
        }

        // 端末の状態画面
        findViewById<View>(R.id.device_info_setting).setOnClickListener {
            findViewById<SwitchCompat>(R.id.device_info_setting_switch).let { switch ->
                switch.isChecked = if (switch.isChecked) {
                    hideDeviceInfoNotification()
                    !switch.isChecked
                } else {
                    showDeviceInfoNotification()
                    !switch.isChecked
                }
            }
        }

        // 画面設定
        findViewById<View>(R.id.device_display_setting).setOnClickListener {
            findViewById<SwitchCompat>(R.id.device_display_setting_switch).let { switch ->
                switch.isChecked = if (switch.isChecked) {
                    hideDisplayNotification()
                    !switch.isChecked
                } else {
                    showDisplayNotification()
                    !switch.isChecked
                }

            }
        }

        // 開発者向けオプション
        findViewById<View>(R.id.development_setting).setOnClickListener {
            findViewById<SwitchCompat>(R.id.development_setting_switch).let { switch ->
                switch.isChecked = if (switch.isChecked) {
                    hideDevelopmentNotification()
                    !switch.isChecked
                } else {
                    showDevelopmentNotification()
                    !switch.isChecked
                }
            }
        }

        // 設定アプリ
        findViewById<View>(R.id.setting).setOnClickListener {
            findViewById<SwitchCompat>(R.id.setting_switch).let { switch ->
                switch.isChecked = if (switch.isChecked) {
                    hideSettingNotification()
                    !switch.isChecked
                } else {
                    showSettingNotification()
                    !switch.isChecked
                }
            }
        }

        // アプリ一覧
        findViewById<View>(R.id.button_app_list).setOnClickListener {
            startActivity(Intent(applicationContext, AppListActivity::class.java))
        }
    }

    private fun showDateSettingNotification() {
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            Intent(Settings.ACTION_DATE_SETTINGS),
            PendingIntent.FLAG_IMMUTABLE
        )
        NotificationUtil.showNotification(
            this,
            titleResId = R.string.device_date_setting,
            priority = NotificationCompat.PRIORITY_HIGH,
            pendingIntent = pendingIntent,
            notificationId = R.string.device_date_setting,
            smallIcon = R.drawable.ic_baseline_access_time_24
        )
    }

    private fun hideDateSettingNotification() {
        NotificationUtil.hideNotification(
            this,
            R.string.device_date_setting
        )
    }

    private fun showDataSaverNotification() {
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS),
            PendingIntent.FLAG_IMMUTABLE
        )
        NotificationUtil.showNotification(
            this,
            titleResId = R.string.battery_save_setting,
            pendingIntent = pendingIntent,
            notificationId = R.string.battery_save_setting,
            smallIcon = R.drawable.ic_baseline_battery_24
        )
    }

    private fun hideDataSaverNotification() {
        NotificationUtil.hideNotification(
            this,
            R.string.battery_save_setting
        )
    }

    private fun showDeviceInfoNotification() {
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            Intent(Settings.ACTION_DEVICE_INFO_SETTINGS),
            PendingIntent.FLAG_IMMUTABLE
        )
        NotificationUtil.showNotification(
            this,
            titleResId = R.string.device_info_setting,
            pendingIntent = pendingIntent,
            notificationId = R.string.device_info_setting,
            smallIcon = R.drawable.ic_baseline_device_information_24
        )
    }

    private fun hideDeviceInfoNotification() {
        NotificationUtil.hideNotification(
            this,
            R.string.device_info_setting
        )
    }

    private fun showDisplayNotification() {
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            Intent(Settings.ACTION_DISPLAY_SETTINGS),
            PendingIntent.FLAG_IMMUTABLE
        )
        NotificationUtil.showNotification(
            this,
            titleResId = R.string.device_display_setting,
            pendingIntent = pendingIntent,
            notificationId = R.string.device_display_setting,
            smallIcon = R.drawable.ic_baseline_phone_android_24
        )
    }

    private fun hideDisplayNotification() {
        NotificationUtil.hideNotification(
            this,
            R.string.device_display_setting,
        )
    }

    private fun showDevelopmentNotification() {
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS),
            PendingIntent.FLAG_IMMUTABLE
        )
        NotificationUtil.showNotification(
            this,
            titleResId = R.string.development_setting,
            pendingIntent = pendingIntent,
            notificationId = R.string.development_setting,
            smallIcon = R.drawable.ic_baseline_developer_mode_24
        )
    }

    private fun hideDevelopmentNotification() {
        NotificationUtil.hideNotification(
            this,
            R.string.development_setting
        )
    }

    private fun showSettingNotification() {
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            Intent(Settings.ACTION_SETTINGS),
            PendingIntent.FLAG_IMMUTABLE
        )
        NotificationUtil.showNotification(
            this,
            titleResId = R.string.device_setting,
            pendingIntent = pendingIntent,
            notificationId = R.string.device_setting,
            smallIcon = R.drawable.ic_baseline_settings_24
        )
    }

    private fun hideSettingNotification() {
        NotificationUtil.hideNotification(
            this,
            R.string.device_setting
        )
    }
}
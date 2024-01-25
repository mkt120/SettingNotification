package com.mkt120.settingnotification.util

import android.content.Context

object PreferenceUtil {
    fun isShowTime(context: Context): Boolean {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .getBoolean(PREF_BOOL_IS_SHOW_TIME, false)
    }

    fun setShowTime(context: Context, isShow: Boolean) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(PREF_BOOL_IS_SHOW_TIME, isShow)
            .apply()
    }

    fun isShowDeviceInfo(context: Context): Boolean {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .getBoolean(PREF_BOOL_IS_SHOW_DEVICE_INFO, false)
    }
    fun setShowDeviceInfo(context: Context, isShow: Boolean) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(PREF_BOOL_IS_SHOW_DEVICE_INFO, isShow)
            .apply()
    }

    fun isShowDisplay(context: Context): Boolean {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .getBoolean(PREF_BOOL_IS_SHOW_DISPLAY, false)
    }
    fun setShowDisplay(context: Context, isShow: Boolean) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(PREF_BOOL_IS_SHOW_DISPLAY, isShow)
            .apply()
    }

    fun isShowBatterySave(context: Context): Boolean {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .getBoolean(PREF_BOOL_IS_SHOW_BATTERY_SAVE, false)
    }
    fun setShowBatterySave(context: Context, isShow: Boolean) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(PREF_BOOL_IS_SHOW_BATTERY_SAVE, isShow)
            .apply()
    }

    fun isShowDeveloper(context: Context): Boolean {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .getBoolean(PREF_BOOL_IS_SHOW_DEVELOPER, false)
    }
    fun setShowDeveloper(context: Context, isShow: Boolean) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(PREF_BOOL_IS_SHOW_DEVELOPER, isShow)
            .apply()
    }

    fun isShowSetting(context: Context): Boolean {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .getBoolean(PREF_BOOL_IS_SHOW_SETTING, false)
    }
    fun setShowSetting(context: Context, isShow: Boolean) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(PREF_BOOL_IS_SHOW_SETTING, isShow)
            .apply()
    }


    private const val PREF_NAME = "com.mkt120.settingnotification.pref"

    private const val PREF_BOOL_IS_SHOW_TIME = "com.mkt120.settingnotification.is_show_time"
    private const val PREF_BOOL_IS_SHOW_DEVICE_INFO = "com.mkt120.settingnotification.is_show_time"
    private const val PREF_BOOL_IS_SHOW_DISPLAY = "com.mkt120.settingnotification.is_show_display"
    private const val PREF_BOOL_IS_SHOW_BATTERY_SAVE: String = "com.mkt120.settingnotification.is_show_battery_save"
    private const val PREF_BOOL_IS_SHOW_DEVELOPER = "com.mkt120.settingnotification.is_show_developer"
    private const val PREF_BOOL_IS_SHOW_SETTING = "com.mkt120.settingnotification.is_show_time"
}
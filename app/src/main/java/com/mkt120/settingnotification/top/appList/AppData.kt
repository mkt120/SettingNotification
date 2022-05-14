package com.mkt120.settingnotification.top.appList

import android.content.ComponentName
import android.graphics.drawable.Drawable

data class AppData(
    val appName: String,
    val componentName: ComponentName,
    val icon: Drawable
)

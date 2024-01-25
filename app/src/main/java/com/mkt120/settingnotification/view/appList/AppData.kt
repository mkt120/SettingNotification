package com.mkt120.settingnotification.view.appList

import android.content.pm.ResolveInfo
import android.graphics.drawable.Drawable

data class AppData(
    val appName: String,
    val resolveInfo: ResolveInfo,
    val icon: Drawable
)
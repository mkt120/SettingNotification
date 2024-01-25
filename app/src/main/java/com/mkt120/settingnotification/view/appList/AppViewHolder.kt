package com.mkt120.settingnotification.view.appList

import android.content.pm.ResolveInfo
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mkt120.settingnotification.R

class AppViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(R.layout.app_view_holder, parent, false)
) {

    fun bind(
        appData: AppData,
        onClick: (String, ResolveInfo) -> Unit
    ) {
        itemView.findViewById<TextView>(R.id.text_view).text = appData.appName
        itemView.findViewById<ImageView>(R.id.image_view).setImageDrawable(appData.icon)
        itemView.setOnClickListener {
            onClick(appData.appName, appData.resolveInfo)
        }
    }
}

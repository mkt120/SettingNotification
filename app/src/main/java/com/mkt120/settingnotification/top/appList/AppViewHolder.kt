package com.mkt120.settingnotification.top.appList

import android.content.ComponentName
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mkt120.settingnotification.R

class AppViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.app_view_holder, null, false)
) {

    fun bind(
        componentName: ComponentName,
        appName: String,
        drawable: Drawable,
        onClick: (componentName: ComponentName) -> Unit
    ) {
        itemView.findViewById<TextView>(R.id.text_view).text = appName
        itemView.findViewById<ImageView>(R.id.image_view).setImageDrawable(drawable)
        itemView.setOnClickListener {
            onClick(componentName)
        }
    }
}

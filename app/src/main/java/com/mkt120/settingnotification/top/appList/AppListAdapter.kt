package com.mkt120.settingnotification.top.appList

import android.content.ComponentName
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AppListAdapter(
    private val list: List<AppData>,
    private val onClick: (componentName: ComponentName) -> Unit
) :
    RecyclerView.Adapter<AppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        return AppViewHolder(parent)
    }

    override fun onBindViewHolder(
        holder: AppViewHolder,
        position: Int,
    ) {
        holder.bind(
            list[position].componentName,
            list[position].appName,
            list[position].icon,
            onClick
        )
    }

    override fun getItemCount(): Int = list.size
}

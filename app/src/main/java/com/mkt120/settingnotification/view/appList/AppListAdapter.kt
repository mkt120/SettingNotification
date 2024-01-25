package com.mkt120.settingnotification.view.appList

import android.content.pm.ResolveInfo
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AppListAdapter(
    private val list: List<AppData>,
    private val onClick: (String, ResolveInfo) -> Unit
) :
    RecyclerView.Adapter<AppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        return AppViewHolder(parent)
    }

    override fun onBindViewHolder(
        holder: AppViewHolder,
        position: Int,
    ) {
        holder.bind(appData = list[position], onClick = onClick)
    }

    override fun getItemCount(): Int = list.size
}

package com.mkt120.settingnotification.view.top

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.mkt120.settingnotification.R
import com.mkt120.settingnotification.domain.Setting

class SettingAdapter(
    private val list: List<Setting>,
    private val listener: SettingItemViewHolder.Listener?
) : Adapter<SettingItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingItemViewHolder {
        return SettingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_setting_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SettingItemViewHolder, position: Int) {
        holder.bind(list[position], listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
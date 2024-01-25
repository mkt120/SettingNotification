package com.mkt120.settingnotification.view.top

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mkt120.settingnotification.R
import com.mkt120.settingnotification.domain.Setting

class SettingItemViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(setting: Setting, listener: Listener?) {
        val textView = itemView.findViewById<TextView>(R.id.text_view)
        if (setting.textResId != 0) {
            textView.setText(setting.textResId)
        } else {
            textView.text = setting.text
        }
        itemView.setOnClickListener {
            val switch = itemView.findViewById<SwitchCompat>(R.id.switch_view)
            switch.isChecked = !switch.isChecked
            listener?.onClick(switch.isChecked, setting)
        }
    }

    interface Listener {
        fun onClick(newValue: Boolean, setting: Setting)
    }
}

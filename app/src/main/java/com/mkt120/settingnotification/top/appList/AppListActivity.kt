package com.mkt120.settingnotification.top.appList

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.mkt120.settingnotification.R

class AppListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = packageManager.let { packageManager ->
            val list = packageManager.queryIntentActivities(
                Intent(Intent.ACTION_MAIN).apply {
                    addCategory(Intent.CATEGORY_LAUNCHER)
                },
                PackageManager.MATCH_ALL
            ).map {
                val name = it.loadLabel(packageManager).toString()
                val icon = it.loadIcon(packageManager)
                AppData(
                    name,
                    ComponentName(it.activityInfo.packageName, it.activityInfo.name),
                    icon
                )
            }
            AppListAdapter(list) { componentName ->
                startActivity(
                    Intent(Intent.ACTION_MAIN).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        component = componentName
                    }
                )
            }
        }
    }


}
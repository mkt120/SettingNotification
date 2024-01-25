package com.mkt120.settingnotification.view

import android.Manifest
import android.app.Person
import android.os.Build
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.appcompat.app.AppCompatActivity
import com.mkt120.settingnotification.R
import com.mkt120.settingnotification.domain.Setting
import com.mkt120.settingnotification.view.top.TopFragment
import java.security.Permission

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, TopFragment.newInstance())
            commitAllowingStateLoss()
        }
    }

    private val launcher = registerForActivityResult(RequestPermission()) {
    }

    override fun onStart() {
        super.onStart()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }
}
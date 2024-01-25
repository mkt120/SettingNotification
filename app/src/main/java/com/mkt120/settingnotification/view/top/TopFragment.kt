package com.mkt120.settingnotification.view.top

import android.app.PendingIntent
import android.content.Intent
import android.content.pm.ResolveInfo
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.*
import androidx.core.app.NotificationCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.mkt120.settingnotification.Const
import com.mkt120.settingnotification.R
import com.mkt120.settingnotification.domain.Setting
import com.mkt120.settingnotification.util.NotificationUtil
import com.mkt120.settingnotification.view.appList.AppListDialogFragment

class TopFragment : Fragment(), SettingItemViewHolder.Listener {

    private val list: MutableList<Setting> = mutableListOf(
        Setting.Time,
        Setting.DeviceInfo,
        Setting.Display,
        Setting.BatterySave,
        Setting.Developer,
        Setting.Setting
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_top, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_app_list -> {
                val fragment = AppListDialogFragment.newInstance(FRAGMENT_RESULT_REQUEST_KEY)
                parentFragmentManager.setFragmentResultListener(
                    FRAGMENT_RESULT_REQUEST_KEY,
                    this
                ) { _, result ->
                    val appName = result.getString(AppListDialogFragment.RESULT_APP_NAME)!!
                    val resolveInfo =
                        result.getParcelable<ResolveInfo>(AppListDialogFragment.RESULT_RESOLVE_INFO)!!
                    val packageName = resolveInfo.activityInfo.packageName
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).also {
                        it.data = Uri.parse("package:${packageName}")
                    }
                    val setting = Setting(
                        text = appName,
                        intent = intent,
                        packageName = packageName
                    )
                    list.add(setting)
                    recyclerView.adapter?.notifyItemInserted(list.size)
                }
                fragment.show(parentFragmentManager, null)
            }
        }
        return true
    }

    private val recyclerView by lazy {
        requireView().findViewById<RecyclerView>(R.id.recycler_view)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = SettingAdapter(list, this@TopFragment)
    }

    override fun onClick(newValue: Boolean, setting: Setting) {
        val pendingIntent = PendingIntent.getActivity(
            requireContext(),
            0,
            setting.intent,
            PendingIntent.FLAG_IMMUTABLE
        )
        if (newValue) {
            NotificationUtil.showNotification(
                context = requireContext(),
                channelId = Const.NOTIFICATION_CHANNEL_ID,
                pendingIntent = pendingIntent,
                notificationId = setting.notificationId,
                title = resources.getString(setting.textResId),
                smallIconResId = setting.smallIconResId,
                deleteNotificationBundle = bundleOf(
                    NotificationUtil.EXTRA_INT_NOTIFICATION_ID to setting.notificationId,
                    NotificationUtil.EXTRA_STR_PACKAGE_NAME to setting.packageName
                ),
                onGoing = true,
                priority = NotificationCompat.PRIORITY_HIGH
            )
        } else {
            NotificationUtil.hideNotification(requireContext(), setting.notificationId)
        }
    }

    companion object {
        private const val FRAGMENT_RESULT_REQUEST_KEY = "request_key"

        fun newInstance(): TopFragment {
            return TopFragment().apply {
                arguments = bundleOf()
            }
        }
    }
}
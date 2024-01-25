package com.mkt120.settingnotification.view.appList

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.mkt120.settingnotification.R

class AppListDialogFragment : DialogFragment() {

    private val packageManager: PackageManager by lazy {
        requireContext().packageManager
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireActivity()).also { dialog ->
            val view =
                LayoutInflater.from(requireContext()).inflate(R.layout.fragment_app_list, null)
                    .also { view ->
                        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
                        recyclerView.adapter = packageManager.let { packageManager ->
                            val list = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                packageManager.queryIntentActivities(
                                    Intent(Intent.ACTION_MAIN).apply {
                                        addCategory(Intent.CATEGORY_LAUNCHER)
                                    },
                                    PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_ALL.toLong())
                                )
                            } else {
                                packageManager.queryIntentActivities(
                                    Intent(Intent.ACTION_MAIN).apply {
                                        addCategory(Intent.CATEGORY_LAUNCHER)
                                    },
                                    PackageManager.MATCH_ALL
                                )
                            }.map {
                                val name = it.loadLabel(packageManager).toString()
                                val icon = it.loadIcon(packageManager)
                                AppData(
                                    name,
                                    it,
                                    icon
                                )
                            }
                            AppListAdapter(list) { appName, resolveInfo ->
                                val requestKey = requireArguments().getString(REQUEST_KEY)!!
                                val bundle = Bundle().apply {
                                    putString(RESULT_APP_NAME, appName)
                                    putParcelable(RESULT_RESOLVE_INFO, resolveInfo)
                                }
                                parentFragmentManager.setFragmentResult(requestKey, bundle)
                                dismiss()
                            }
                        }
                    }
            dialog.setContentView(view)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        private const val REQUEST_KEY = "request_key"
        const val RESULT_APP_NAME = "result_app_name"
        const val RESULT_RESOLVE_INFO = "result_resolve_info"
        fun newInstance(requestKey: String): AppListDialogFragment {
            return AppListDialogFragment().apply {
                arguments = bundleOf(REQUEST_KEY to requestKey)
            }
        }
    }
}
package com.mozhimen.permissionk.xxpermissions

import android.content.Context
import com.mozhimen.kotlin.utilk.android.app.UtilKActivityStart

/**
 * @ClassName XXPermissionNavHostUtil
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/22
 * @Version 1.0
 */
object XXPermissionsNavHostUtil {

    //去设置页面详情页
    @JvmStatic
    fun startPermission_EXTERNAL_STORAGE(context: Context) {
        UtilKActivityStart.startSettingsManageAllFilesAccessPermission(context)
    }

    //去设置未知源页
    @JvmStatic
    fun startPermission_REQUEST_INSTALL_PACKAGES(context: Context) {
        UtilKActivityStart.startSettingsManageUnknownInstallSource(context)
    }

    @JvmStatic
    fun startPermission_POST_NOTIFICATIONS(context: Context) {
        UtilKActivityStart.startSettingsAppNotificationSettings(context)
    }

    @JvmStatic
    fun startPermission_BLUETOOTH(context: Context) {
        UtilKActivityStart.startBluetoothAdapterRequestEnable(context)
    }

    @JvmStatic
    fun startPermission_DEFAULT(context: Context) {
        UtilKActivityStart.startSettingsApplicationDetailsSettings(context)
    }
}
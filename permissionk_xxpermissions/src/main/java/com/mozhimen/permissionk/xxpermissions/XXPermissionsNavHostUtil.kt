package com.mozhimen.permissionk.xxpermissions

import android.content.Context
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_MANAGE_EXTERNAL_STORAGE
import com.mozhimen.kotlin.elemk.android.cons.CPermission
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
    fun startSettingManageStorage(context: Context) {
        UtilKActivityStart.startSettingsManageAllFilesAccessPermission(context)
    }

    //去设置未知源页
    @JvmStatic
    fun startSettingInstall(context: Context) {
        UtilKActivityStart.startSettingsManageUnknownInstallSource(context)
    }

    @JvmStatic
    fun startSettingNotification(context: Context) {
        UtilKActivityStart.startSettingsAppNotificationSettings(context)
    }

    @JvmStatic
    fun startSettingApplicationDetailsSettings(context: Context) {
        UtilKActivityStart.startSettingsApplicationDetailsSettings(context)
    }

    @JvmStatic
    fun startBluetoothAdapterRequestEnable(context: Context) {
        UtilKActivityStart.startBluetoothAdapterRequestEnable(context)
    }
}
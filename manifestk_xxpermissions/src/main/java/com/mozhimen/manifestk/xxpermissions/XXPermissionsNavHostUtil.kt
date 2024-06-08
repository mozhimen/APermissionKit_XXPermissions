package com.mozhimen.manifestk.xxpermissions

import android.content.Context
import androidx.annotation.RequiresPermission
import com.mozhimen.basick.lintk.optins.permission.OPermission_MANAGE_EXTERNAL_STORAGE
import com.mozhimen.basick.manifestk.cons.CPermission
import com.mozhimen.basick.utilk.android.app.UtilKActivityStart

/**
 * @ClassName XXPermissionNavHostUtil
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/22
 * @Version 1.0
 */
object XXPermissionsNavHostUtil {

    //去设置页面详情页

    @OPermission_MANAGE_EXTERNAL_STORAGE
    @RequiresPermission(CPermission.MANAGE_EXTERNAL_STORAGE)
    @JvmStatic
    fun startSettingManageStorage(context: Context) {
        UtilKActivityStart.startSettingManageAllFilesAccessPermission(context)
    }

    //去设置未知源页
    @JvmStatic
    fun startSettingInstall(context: Context) {
        UtilKActivityStart.startSettingManageUnknownInstallSource(context)
    }

    @JvmStatic
    fun startSettingNotification(context: Context) {
        UtilKActivityStart.startSettingAppNotificationSettings(context)
    }
}
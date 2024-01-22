package com.mozhimen.manifestk.xxpermissions

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.mozhimen.basick.elemk.android.os.cons.CVersCode
import com.mozhimen.basick.manifestk.annors.AManifestKRequire
import com.mozhimen.basick.manifestk.cons.CPermission
import com.mozhimen.basick.utilk.android.app.UtilKLaunchActivity

/**
 * @ClassName XXPermissionNavHostUtil
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/22
 * @Version 1.0
 */
object XXPermissionsNavHostUtil {

    //去设置页面详情页
    @RequiresPermission(CPermission.MANAGE_EXTERNAL_STORAGE)
    @AManifestKRequire(CPermission.MANAGE_EXTERNAL_STORAGE)
    @JvmStatic
    fun startSettingManageStorage(context: Context) {
        UtilKLaunchActivity.startManageAllFilesAccess(context)
    }

    //去设置未知源页
    @JvmStatic
    fun startSettingInstall(context: Context) {
        UtilKLaunchActivity.startManageUnknownInstallSource(context)
    }

    @JvmStatic
    fun startSettingNotification(context: Context) {
        UtilKLaunchActivity.startAppNotificationSettings(context)
    }
}
package com.mozhimen.manifestk.xxpermissions

import android.content.Context
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions
import com.mozhimen.basick.elemk.android.os.cons.CVersCode
import com.mozhimen.basick.elemk.commons.I_Listener
import com.mozhimen.basick.manifestk.cons.CPermission
import com.mozhimen.basick.utilk.android.app.UtilKLaunchActivity
import com.mozhimen.basick.utilk.android.content.UtilKApplicationInfo

/**
 * @ClassName HelperPermission
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/11/24 16:21
 * @Version 1.0
 */
object XXPermissionsUtil {
    //是否有通知权限
    @JvmStatic
    fun hasPostNotificationPermission(context: Context): Boolean =
        XXPermissions.isGranted(context, Permission.POST_NOTIFICATIONS)

    //是否有读写权限
    @JvmStatic
    fun hasReadWritePermission(context: Context): Boolean =
        XXPermissions.isGranted(context, Permission.MANAGE_EXTERNAL_STORAGE)

    //是否有安装权限
    @JvmStatic
    fun hasInstallPermission(context: Context): Boolean =
        XXPermissions.isGranted(context, Permission.REQUEST_INSTALL_PACKAGES)

    //////////////////////////////////////////////////////////////////////////

    //申请通知权限
    @JvmStatic
    fun requestNotificationPermission(context: Context, onGranted: I_Listener, onDenied: I_Listener) {
        XXPermissions.with(context)
            .permission(Permission.POST_NOTIFICATIONS)
//            .interceptor(PermissionInterceptor())
            .request { _, allGranted -> if (allGranted) onGranted.invoke() else onDenied.invoke() }
    }

    //申请读写权限
    @JvmStatic
    fun requestReadWritePermission(context: Context, onGranted: I_Listener, onDenied: I_Listener) {
        if (UtilKApplicationInfo.getTargetSdkVersion(context) >= CVersCode.V_30_11_R) {
            XXPermissions.with(context) // 适配分区存储应该这样写
                //.permission(Permission.Group.STORAGE)
                // 不适配分区存储应该这样写
                .permission(Permission.MANAGE_EXTERNAL_STORAGE)
//            .interceptor(PermissionInterceptor())
                .request { _, allGranted -> if (allGranted) onGranted.invoke() else onDenied.invoke() }
        } else /*if (UtilKApplicationInfo.getTargetSdkVersion(this)!! >= CVersCode.V_23_6_M)*/
            XXPermissions.with(context) // 适配分区存储应该这样写
                //.permission(Permission.Group.STORAGE)
                // 不适配分区存储应该这样写
                .permission(Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE)
//            .interceptor(PermissionInterceptor())
                .request { _, allGranted -> if (allGranted) onGranted.invoke() else onDenied.invoke() }
    }

    //申请安装权限
    @JvmStatic
    fun requestInstallPermission(context: Context, onGranted: I_Listener, onDenied: I_Listener) {
        XXPermissions.with(context)
            .permission(Permission.REQUEST_INSTALL_PACKAGES)
//            .interceptor(PermissionInterceptor())
            .request { _, allGranted -> if (allGranted) onGranted.invoke() else onDenied.invoke() }
    }

    //////////////////////////////////////////////////////////////////////////

    //去设置页面详情页
    @RequiresApi(CVersCode.V_30_11_R)
    @RequiresPermission(CPermission.MANAGE_EXTERNAL_STORAGE)
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
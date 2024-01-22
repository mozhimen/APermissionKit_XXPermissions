package com.mozhimen.manifestk.xxpermissions

import android.content.Context
import androidx.annotation.RequiresPermission
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions
import com.mozhimen.basick.manifestk.annors.AManifestKRequire
import com.mozhimen.basick.manifestk.cons.CApplication
import com.mozhimen.basick.manifestk.cons.CPermission

/**
 * @ClassName XXPermissionCheckUtil
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/22
 * @Version 1.0
 */
object XXPermissionsCheckUtil {
    //是否有获取程序包名权限
    @JvmStatic
    @RequiresPermission(Permission.GET_INSTALLED_APPS)
    @AManifestKRequire(Permission.GET_INSTALLED_APPS)
    fun hasInstalledAppsPermission(context: Context): Boolean =
        XXPermissions.isGranted(context, Permission.GET_INSTALLED_APPS)

    //是否有通知权限
    @JvmStatic
    @RequiresPermission(Permission.POST_NOTIFICATIONS)
    @AManifestKRequire(Permission.POST_NOTIFICATIONS)
    fun hasPostNotificationPermission(context: Context): Boolean =
        XXPermissions.isGranted(context, Permission.POST_NOTIFICATIONS)

    //是否有读写权限
    @JvmStatic
    @RequiresPermission(allOf = [CPermission.MANAGE_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE])
    @AManifestKRequire(CPermission.MANAGE_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE, CApplication.REQUEST_LEGACY_EXTERNAL_STORAGE)
    fun hasReadWritePermission(context: Context): Boolean =
        XXPermissions.isGranted(context, Permission.MANAGE_EXTERNAL_STORAGE)

    //是否有安装权限
    @JvmStatic
    @RequiresPermission(Permission.REQUEST_INSTALL_PACKAGES)
    @AManifestKRequire(Permission.REQUEST_INSTALL_PACKAGES)
    fun hasInstallPermission(context: Context): Boolean =
        XXPermissions.isGranted(context, Permission.REQUEST_INSTALL_PACKAGES)

}
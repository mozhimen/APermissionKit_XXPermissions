package com.mozhimen.permissionk.xxpermissions

import android.content.Context
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.hjq.permissions.XXPermissions
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_ACCESS_COARSE_LOCATION
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_ACCESS_FINE_LOCATION
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_BLUETOOTH_ADVERTISE
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_BLUETOOTH_CONNECT
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_BLUETOOTH_SCAN
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_CAMERA
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_GET_INSTALLED_APPS
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_MANAGE_EXTERNAL_STORAGE
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_POST_NOTIFICATIONS
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_READ_EXTERNAL_STORAGE
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_REQUEST_INSTALL_PACKAGES
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_SYSTEM_ALERT_WINDOW
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_WRITE_EXTERNAL_STORAGE
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName XXPermissionCheckUtil
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/22
 * @Version 1.0
 */
object XXPermissionsCheckUtil : IUtilK {
    //是否有获取程序包名权限
    @JvmStatic
    @RequiresPermission(CPermission.GET_INSTALLED_APPS)
    @OUsesPermission_GET_INSTALLED_APPS
    fun hasPermission_GET_INSTALLED_APPS(context: Context): Boolean =
        XXPermissions.isGranted(context, CPermission.GET_INSTALLED_APPS)

    //是否有通知权限
    @JvmStatic
    @RequiresPermission(CPermission.POST_NOTIFICATIONS)
    @OUsesPermission_POST_NOTIFICATIONS
    fun hasPermission_POST_NOTIFICATIONS(context: Context): Boolean =
        (if (UtilKBuildVersion.isAfterV_33_13_T()) XXPermissions.isGranted(context, CPermission.POST_NOTIFICATIONS) else true).also { UtilKLogWrapper.d(TAG, "hasPostNotificationPermission: ") }

    //是否有读写权限
    @JvmStatic
    @RequiresPermission(allOf = [CPermission.MANAGE_EXTERNAL_STORAGE, CPermission.WRITE_EXTERNAL_STORAGE, CPermission.READ_EXTERNAL_STORAGE])
    @OUsesPermission_READ_EXTERNAL_STORAGE
    @OUsesPermission_WRITE_EXTERNAL_STORAGE
    @OUsesPermission_MANAGE_EXTERNAL_STORAGE
    fun hasPermission_EXTERNAL_STORAGE(context: Context): Boolean =
        if (UtilKBuildVersion.isAfterV_30_11_R())
            XXPermissions.isGranted(context, CPermission.MANAGE_EXTERNAL_STORAGE)
        else
            XXPermissions.isGranted(context, CPermission.READ_EXTERNAL_STORAGE, CPermission.WRITE_EXTERNAL_STORAGE)

    //是否有安装权限
    @JvmStatic
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    @OUsesPermission_REQUEST_INSTALL_PACKAGES
    fun hasPermission_REQUEST_INSTALL_PACKAGES(context: Context): Boolean =
        if (UtilKBuildVersion.isAfterV_23_6_M()) XXPermissions.isGranted(context, CPermission.REQUEST_INSTALL_PACKAGES) else true

    //是否有相机权限
    @JvmStatic
    @RequiresPermission(allOf = [CPermission.CAMERA])
    @OUsesPermission_CAMERA
    fun hasPermission_CAMERA(context: Context): Boolean =
        XXPermissions.isGranted(context, CPermission.CAMERA)

    //是否有位置权限
    @JvmStatic
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    @OUsesPermission_ACCESS_COARSE_LOCATION
    @OUsesPermission_ACCESS_FINE_LOCATION
    fun hasPermission_LOCATION(context: Context): Boolean =
        XXPermissions.isGranted(context, CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION)

    //是否有悬浮窗
    @JvmStatic
    @RequiresPermission(CPermission.SYSTEM_ALERT_WINDOW)
    @OUsesPermission_SYSTEM_ALERT_WINDOW
    fun hasPermission_SYSTEM_ALERT_WINDOW(context: Context): Boolean =
        XXPermissions.isGranted(context, CPermission.SYSTEM_ALERT_WINDOW)

    //是否有蓝牙权限
    @JvmStatic
    @RequiresApi(CVersCode.V_23_6_M)
    @RequiresPermission(allOf = [CPermission.ACCESS_FINE_LOCATION, CPermission.ACCESS_COARSE_LOCATION])
    @OUsesPermission_ACCESS_COARSE_LOCATION
    @OUsesPermission_ACCESS_FINE_LOCATION
    fun hasPermission_BLUETOOTH_aftter23(context: Context):Boolean=
        hasPermission_LOCATION(context)

    @JvmStatic
    @RequiresApi(CVersCode.V_31_12_S)
    @RequiresPermission(allOf = [CPermission.BLUETOOTH_SCAN, CPermission.BLUETOOTH_CONNECT, CPermission.BLUETOOTH_ADVERTISE])
    @OUsesPermission_BLUETOOTH_SCAN
    @OUsesPermission_BLUETOOTH_CONNECT
    @OUsesPermission_BLUETOOTH_ADVERTISE
    fun hasPermission_BLUETOOTH_aftter31(context: Context):Boolean=
        XXPermissions.isGranted(context, CPermission.BLUETOOTH_SCAN, CPermission.BLUETOOTH_CONNECT, CPermission.BLUETOOTH_ADVERTISE)
}
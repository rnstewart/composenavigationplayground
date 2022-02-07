package com.zmosoft.composenavigationplayground.utils

import android.Manifest
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

object CommonFunctions {
    fun checkLocationPermissions(fragment: Fragment): Boolean {
        return fragment.activity?.let { activity ->
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                true
            } else {
                fragment.requestPermissions(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ),
                    Constants.RequestCodes.REQUEST_LOCATION_PERMISSION
                )
                false
            }
        } ?: false
    }
}
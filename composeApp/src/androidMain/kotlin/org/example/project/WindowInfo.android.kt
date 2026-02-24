package org.example.project

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import network.chaintech.sdpcomposemultiplatform.sdp


@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
actual fun rememberWindowInfo(): WindowInfo {
    val configuration = LocalConfiguration.current

    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp

    val screenWidth = screenWidthDp.sdp
    val screenHeight = screenHeightDp.sdp

    val widthType = when {
        screenWidthDp < 600 -> WindowInfo.WindowType.Compact
        screenWidthDp < 1200 -> WindowInfo.WindowType.Medium
        else -> WindowInfo.WindowType.Expanded
    }


    val heightType = when {
        screenHeightDp < 480 -> WindowInfo.WindowType.Compact
        screenHeightDp < 900 -> WindowInfo.WindowType.Medium
        else -> WindowInfo.WindowType.Expanded
    }

    return WindowInfo(
        screenWidthInfo = widthType,
        screenHeightInfo = heightType,
        screenWidth = screenWidth,
        screenHeight = screenHeight
    )
}
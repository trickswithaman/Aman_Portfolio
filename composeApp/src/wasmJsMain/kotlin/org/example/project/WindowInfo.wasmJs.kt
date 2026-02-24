package org.example.project

import androidx.compose.runtime.Composable
import kotlinx.browser.window
import network.chaintech.sdpcomposemultiplatform.sdp


// chatgpt suggestion
@Composable
actual fun rememberWindowInfo(): WindowInfo {
    val widthDp = window.innerWidth
    val heightDp = window.innerHeight

    // Don't divide by density — values are already DPs on most modern browsers
    val screenWidth = widthDp.sdp
    val screenHeight = heightDp.sdp

    val widthType = when {
        widthDp < 600 -> WindowInfo.WindowType.Compact
        widthDp < 1024 -> WindowInfo.WindowType.Medium
        else -> WindowInfo.WindowType.Expanded
    }

    val heightType = when {
        heightDp < 480 -> WindowInfo.WindowType.Compact
        heightDp < 900 -> WindowInfo.WindowType.Medium
        else -> WindowInfo.WindowType.Expanded
    }

    println("🌀 widthDp: $widthDp, heightDp: $heightDp")
    println("✅ widthType: $widthType, heightType: $heightType")

    return WindowInfo(
        screenWidthInfo = widthType,
        screenHeightInfo = heightType,
        screenWidth = screenWidth,
        screenHeight = screenHeight
    )
}

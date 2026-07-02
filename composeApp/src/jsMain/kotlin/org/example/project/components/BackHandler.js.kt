package org.example.project.components

import androidx.compose.runtime.*
import kotlinx.browser.window

@Composable
actual fun BackHandler(enabled: Boolean, onBack: () -> Unit) {
    val currentOnBack by rememberUpdatedState(onBack)

    DisposableEffect(enabled) {
        if (enabled) {
            window.history.pushState("back_handler", "")

            val onPopState: (dynamic) -> Unit = {
                currentOnBack()
            }

            window.addEventListener("popstate", onPopState)

            onDispose {
                window.removeEventListener("popstate", onPopState)
                if (window.history.state == "back_handler") {
                    window.history.back()
                }
            }
        } else {
            onDispose {}
        }
    }
}

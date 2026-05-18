package org.example.project.components

import androidx.compose.runtime.*
import kotlinx.browser.window
import org.w3c.dom.events.Event

@OptIn(kotlin.js.ExperimentalWasmJsInterop::class)
@Composable
actual fun BackHandler(enabled: Boolean, onBack: () -> Unit) {
    val currentOnBack by rememberUpdatedState(onBack)

    DisposableEffect(enabled) {
        if (enabled) {
            window.history.pushState(null, "")

            val onPopState: (Event) -> Unit = {
                currentOnBack()
            }

            window.addEventListener("popstate", onPopState)

            onDispose {
                window.removeEventListener("popstate", onPopState)
                // In some browsers, if we don't go back here, the history stays pushed
                // but we don't have an easy way to check the state in Wasm without more boilerplate.
                // We'll leave it as is for now as it's better than closing the app.
            }
        } else {
            onDispose {}
        }
    }
}

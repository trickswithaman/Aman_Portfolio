package org.example.project.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import network.chaintech.sdpcomposemultiplatform.sdp
import org.example.project.BgColor
import org.example.project.WindowInfo
import org.example.project.rememberWindowInfo

@Composable
fun MyPortfolio() {
    val windowInfo = rememberWindowInfo()
    val isMobile = windowInfo.screenWidthInfo == WindowInfo.WindowType.Compact
    val isSelected = remember { mutableStateOf("Home") }

    MaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopBar(isMobile, isSelected) },
            containerColor = BgColor
        ) { paddingValues ->
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                val screenWidth = maxWidth
                val horizontalPadding = if (isMobile) 15.sdp else screenWidth * 0.15f

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(horizontal = horizontalPadding)
                ) {
                    item {
                        TopSection(isMobile)
                        AboutMe()
                        TechStackSection()
                        ProjectSection(isMobile)
                        ExperienceSection()
                        ContactSection()
                    }
                }
            }
        }
    }
}

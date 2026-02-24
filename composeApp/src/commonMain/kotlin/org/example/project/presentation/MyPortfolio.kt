package org.example.project.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import network.chaintech.sdpcomposemultiplatform.sdp
import org.example.project.WindowInfo
import org.example.project.lightGray
import org.example.project.rememberWindowInfo

@Composable
fun MyPortfolio (){
    val windowInfo = rememberWindowInfo()
    val isMobile =  windowInfo.screenWidthInfo == WindowInfo.WindowType.Compact
    val isSelected = remember { mutableStateOf("Home") }

    MaterialTheme {
        Scaffold (
            modifier = Modifier.fillMaxSize(), topBar = {TopBar(isMobile,isSelected)}
        ){ paddingValues ->

            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize().background(Color.White.copy(alpha = 0.3f))

            ) {

                val screenWidth = maxWidth
                val paddingPercent = 0.20f // 20%
                val horizontalPadding = screenWidth * paddingPercent
                Box(
                    modifier = Modifier.padding(horizontal = if (!isMobile)horizontalPadding else 10.sdp).fillMaxSize()
                ) {
                    LazyColumn (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                        ,
                        verticalArrangement = Arrangement.spacedBy(5.sdp)
                    ) {

                        item {
                            TopSection(isMobile)
                            AboutMe()
                            TechStackSection()
                            ProjectSection()
                            ContactSection()
                        }

                    }}}






        }


    }
}

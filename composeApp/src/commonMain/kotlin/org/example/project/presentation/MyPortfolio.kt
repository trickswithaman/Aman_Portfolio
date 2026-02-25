package org.example.project.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch
import network.chaintech.sdpcomposemultiplatform.sdp
import org.example.project.BgColor
import org.example.project.WindowInfo
import org.example.project.rememberWindowInfo

@Composable
fun MyPortfolio() {
    val windowInfo = rememberWindowInfo()
    val isMobile = windowInfo.screenWidthInfo == WindowInfo.WindowType.Compact
    val isSelected = remember { mutableStateOf("Home") }
    var selectedProject by remember { mutableStateOf<String?>(null) }
    
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val scrollToSection: (Int, String) -> Unit = { index, name ->
        isSelected.value = name
        scope.launch {
            listState.animateScrollToItem(index)
        }
    }

    MaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                if (selectedProject == null) {
                    TopBar(
                        isMobile = isMobile,
                        isSelected = isSelected,
                        onNavigate = { section ->
                            when (section) {
                                "Home" -> scrollToSection(0, "Home")
                                "About" -> scrollToSection(1, "About")
                                "Skills" -> scrollToSection(2, "Skills")
                                "Projects" -> scrollToSection(3, "Projects")
                                "Experience" -> scrollToSection(4, "Experience")
                                "Contact" -> scrollToSection(5, "Contact")
                            }
                        }
                    )
                }
            },
            containerColor = BgColor
        ) { paddingValues ->
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                val screenWidth = maxWidth
                val horizontalPadding = if (isMobile) 15.sdp else screenWidth * 0.15f

                AnimatedContent(targetState = selectedProject) { project ->
                    if (project == null) {
                        LazyColumn(
                            state = listState,
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(horizontal = horizontalPadding)
                        ) {
                            item { TopSection(isMobile) }
                            item { AboutMe() }
                            item { TechStackSection() }
                            item { ProjectSection(isMobile) { projectName ->
                                selectedProject = projectName
                            } }
                            item { ExperienceSection() }
                            item { ContactSection() }
                        }
                    } else {
                        Box(modifier = Modifier.padding(horizontal = horizontalPadding)) {
                            ProjectDetail(isMobile = isMobile) {
                                selectedProject = null
                            }
                        }
                    }
                }
            }
        }
    }
}

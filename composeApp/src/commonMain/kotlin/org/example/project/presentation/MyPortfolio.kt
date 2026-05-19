package org.example.project.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import network.chaintech.sdpcomposemultiplatform.sdp
import org.example.project.*
import org.example.project.components.calculateExperience
import org.example.project.components.downloadResume
import org.example.project.components.BackHandler

@Preview(showBackground = true)
@Composable
fun MyPortfolio() {
    // Experience Calculation
    val totalExperience = calculateExperience(
        PortfolioConstants.START_YEAR,
        PortfolioConstants.START_MONTH
    )

    // Window Info & State
    val windowInfo = rememberWindowInfo()
    val isMobile = windowInfo.screenWidthInfo == WindowInfo.WindowType.Compact
    val isSelected = remember { mutableStateOf("Home") }
    var selectedProjectName by remember { mutableStateOf<String?>(null) }

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val scrollToSection: (Int, String) -> Unit = { index, name ->
        isSelected.value = name
        scope.launch {
            listState.animateScrollToItem(index)
        }
    }

    MaterialTheme {
        // Back Navigation Handler
        BackHandler(enabled = selectedProjectName != null) {
            selectedProjectName = null
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                if (selectedProjectName == null) {
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
                val horizontalPadding = if (isMobile) 15.sdp else maxWidth * 0.15f

                AnimatedContent(targetState = selectedProjectName) { targetProjectName ->
                    if (targetProjectName == null) {
                        LazyColumn(
                            state = listState,
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(horizontal = horizontalPadding)
                        ) {
                            // Hero Section
                            item {
                                TopSection(
                                    downloadResume = { downloadResume() },
                                    isMobile = isMobile,
                                    onViewProjectsButton = { scrollToSection(3, "Projects") },
                                    totalExperience = totalExperience,
                                    totalProductionApp = PortfolioConstants.heroData.totalProductionApps,
                                    leftBoxSummary = PortfolioConstants.heroData.summary,
                                    leftBoxHeaderText = PortfolioConstants.heroData.headerText,
                                    specialistCard = PortfolioConstants.heroData.specialistCard
                                )
                            }
                            // About Me Section
                            item {
                                AboutMe(
                                    isMobile = isMobile,
                                    leftText = PortfolioConstants.aboutMeData.leftText,
                                    rightText = PortfolioConstants.aboutMeData.rightText
                                )
                            }
                            // Tech Stack Section
                            item {
                                TechStackSection(
                                    isMobile = isMobile,
                                    skillList = PortfolioConstants.skillsList
                                )
                            }
                            // Projects Section
                            item {
                                ProjectSection(
                                    isMobile = isMobile,
                                    projectData = PortfolioConstants.projects,
                                    onViewCaseStudy = { projectName ->
                                        selectedProjectName = projectName
                                    }
                                )
                            }
                            // Experience Section
                            item {
                                ExperienceSection(
                                    isMobile = isMobile,
                                    experiences = PortfolioConstants.experiences
                                )
                            }
                            // Contact Section
                            item {
                                ContactSection(isMobile = isMobile)
                            }
                        }
                    } else {
                        // Project Detail / Case Study View
                        Box(modifier = Modifier.padding(horizontal = horizontalPadding)) {
                            ProjectDetail(
                                isMobile = isMobile,
                                data = PortfolioConstants.getCaseStudy(targetProjectName)
                            ) {
                                selectedProjectName = null
                            }
                        }
                    }
                }
            }
        }
    }
}

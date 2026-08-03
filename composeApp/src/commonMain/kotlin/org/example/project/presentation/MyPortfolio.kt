package org.example.project.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import network.chaintech.sdpcomposemultiplatform.sdp
import org.example.project.*
import org.example.project.components.downloadResume
import org.example.project.components.BackHandler

@Preview(showBackground = true)

@Composable
fun MyPortfolio(
    viewModel: PortfolioViewModel = viewModel { PortfolioViewModel() }
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val currentDestination = uiState.navigationStack.last()

    // Window Info & State
    val windowInfo = rememberWindowInfo()
    val isMobile = windowInfo.screenWidthInfo == WindowInfo.WindowType.Compact

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val scrollToSection: (PortfolioSection) -> Unit = { section ->
        viewModel.onSectionSelected(section)
        scope.launch {
            listState.animateScrollToItem(section.index)
        }
    }

    // Precise Stack Synchronization
    // We compose a BackHandler for EVERY unique step in the navigation stack.
    // This creates the corresponding entries in browser history/phone back stack.
    uiState.navigationStack.forEachIndexed { index, _ ->
        if (index > 0) { // Skip the very first Main screen
            key(index) {
                BackHandler {
                    viewModel.onBackPress()
                }
            }
        }
    }

    MaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                // TopBar is only visible on the main screen to keep detail views focused
                if (currentDestination == PortfolioDestination.Main) {
                    TopBar(
                        isMobile = isMobile,
                        selectedItem = uiState.selectedSection,
                        onNavigate = { section -> scrollToSection(section) }
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

                AnimatedContent(
                    targetState = currentDestination,
                    transitionSpec = {
                        fadeIn().togetherWith(fadeOut())
                    },
                    label = "PortfolioNavigation"
                ) { destination ->
                    when (destination) {
                        is PortfolioDestination.ProjectDetail -> {
                            Box(modifier = Modifier.padding(horizontal = horizontalPadding)) {
                                ProjectDetail(
                                    isMobile = isMobile,
                                    data = PortfolioConstants.getCaseStudy(destination.projectName)
                                ) {
                                    viewModel.onBackPress()
                                }
                            }
                        }
                        PortfolioDestination.AllProjects -> {
                            AllProjectsScreen(
                                isMobile = isMobile,
                                onBack = {
                                    viewModel.onBackPress()
                                },
                                onViewCaseStudy = { projectName ->
                                    viewModel.onProjectSelected(projectName)
                                }
                            )
                        }
                        PortfolioDestination.Main -> {
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
                                        onViewProjectsButton = { scrollToSection(PortfolioSection.Projects) },
                                        totalExperience = /*uiState.totalExperience*/"1.5+ years",
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
                                            viewModel.onProjectSelected(projectName)
                                        },
                                        onSeeMoreProjects = {
                                            viewModel.setShowAllProjects(true)
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
                        }
                    }
                }
            }
        }
    }
}

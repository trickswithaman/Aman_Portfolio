package org.example.project.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import network.chaintech.sdpcomposemultiplatform.sdp
import org.example.project.BgColor
import org.example.project.PrimaryPurple
import org.example.project.TextDark
import org.example.project.WindowInfo
import org.example.project.components.calculateExperience
import org.example.project.components.downloadResume
import org.example.project.components.BackHandler
import org.example.project.rememberWindowInfo
import kotlin.collections.listOf

@Preview(showBackground = true)
@Composable
fun MyPortfolio() {
    val startYear = 2024
    val startMonth = 11
    val totalExperience = calculateExperience(startYear, startMonth)
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

    val projectsData = getProjectsData()

    val skillsList = listOf(
        "Kotlin",
        "Jetpack Compose",
        "Kotlin Multiplatform (KMP)",
        "MVVM",
        "Clean Architecture",
        "Kotlin Coroutines",
        "State Management",
        "REST API Integration",
        "Retrofit",
        "Ktor",
        "Firebase",
        "Room Database",
        "Git & GitHub",
        "Postman",
        "Debugging"

    )

    MaterialTheme {
        BackHandler(enabled = selectedProject != null) {
            selectedProject = null
        }
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
                            item {
                                TopSection(
                                    downloadResume = { downloadResume() },
                                    isMobile = isMobile,
                                    onViewProjectsButton = { scrollToSection(3, "Projects") },
                                    totalExperience = totalExperience,
                                    totalProductionApp = 5,
                                    leftBoxSummary = "Android Developer with ${totalExperience} of experience building high-quality Android & KMP apps using Jetpack Compose, with a focus on performance, scalability, and clean architecture.",
                                    leftBoxHeaderText = buildAnnotatedString {
                                        append("Native\n")
                                        withStyle(style = SpanStyle(color = PrimaryPurple)) {
                                            append("Android & KMP \nDeveloper")
                                        }
                                    },


                                    )
                            }
                            item {
                                AboutMe(
                                    isMobile = isMobile,
                                    leftText = "Building scalable applications with modern Android development practices and clean architecture.",
                                    rightText = buildAnnotatedString {
                                        append("Android Developer with 1.5+ years of experience building scalable and maintainable applications using ")

                                        withStyle(
                                            style = SpanStyle(
                                                fontWeight = FontWeight.Bold,
                                                color = TextDark
                                            )
                                        ) {
                                            append("Kotlin, Jetpack Compose, and Kotlin Multiplatform")
                                        }

                                        append(". I focus on writing clean, modular code and designing applications that are easy to scale and maintain.\n\n")

                                        append("My approach is centered around performance, code quality, and delivering reliable user experiences. I continuously explore modern Android development practices and aim to build applications that follow industry standards.")
                                    }
                                )
                            }
                            item {
                                TechStackSection(
                                    isMobile = isMobile,
                                    skillList = skillsList
                                )
                            }
                            item {
                                ProjectSection(
                                    isMobile,
                                    projectData = projectsData ,
                                    onViewCaseStudy = {projectName ->
                                        selectedProject = projectName

                                    }

                                    )
                            }
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

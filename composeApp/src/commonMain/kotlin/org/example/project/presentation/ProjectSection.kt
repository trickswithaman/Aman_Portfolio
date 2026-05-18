package org.example.project.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import myportfolio.composeapp.generated.resources.*
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource



@Composable
fun ProjectSection(isMobile: Boolean, onViewCaseStudy: (String) -> Unit, projectData: Array<ProjectData>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.sdp),
        verticalArrangement = Arrangement.spacedBy(10.sdp)

    ) {

        Text(
            text = "Featured Projects",
            fontSize = if (isMobile) 13.ssp else 15.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
            color = TextDark
        )
        Text(
            text = "Real-world applications built with scalability and user experience in mind.",
            fontSize = if (isMobile) 7.ssp else 8.ssp,
            color = TextLight,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Medium)),
            modifier = Modifier.padding(bottom = 12.sdp)
        )


        projectData.forEach {  project ->
        ProjectCard(
            isMobile = isMobile,
            title = project.projectName,
            description = project.projectDescription,
            tags = project.skillTags,
            points = project.impPoints,
            image = project.image,
            isReversed = project.isReversed,
            bgColor = project.imageBackgroundColor,
            onViewCaseStudy = { onViewCaseStudy("Musklr") }
        )
        }
    }
}

@Composable
fun ProjectCard(
    isMobile: Boolean,
    title: String,
    description: String,
    tags: List<String>,
    points: List<String>,
    image: org.jetbrains.compose.resources.DrawableResource,
    bgColor: Color,
    isReversed: Boolean = false,
    onViewCaseStudy: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.sdp),
        shape = RoundedCornerShape(12.sdp),
    ) {
        if (isMobile) {
            Column {
//                ProjectImage(image, bgColor, Modifier.height(150.sdp))
                ProjectDetails(title, description, tags, points, Modifier.fillMaxWidth(), onViewCaseStudy, isMobile)
            }
        } else {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()) {
                if (isReversed) {
                    ProjectDetails(title, description, tags, points, Modifier.weight(1.2f), onViewCaseStudy, isMobile)
                    ProjectImage(image, bgColor, Modifier.weight(1f).height(180.sdp))
                } else {
                    ProjectImage(image, bgColor, Modifier.weight(1f).height(180.sdp))
                    ProjectDetails(title, description, tags, points, Modifier.weight(1.2f), onViewCaseStudy, isMobile)
                }
            }
        }
    }
}

@Composable
fun ProjectImage(image: org.jetbrains.compose.resources.DrawableResource, bgColor: Color, modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .background(bgColor, RoundedCornerShape(8.sdp))
            .padding(12.sdp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun ProjectDetails(
    title: String,
    description: String,
    tags: List<String>,
    points: List<String>,
    modifier: Modifier,
    onViewCaseStudy: () -> Unit,
    isMobile: Boolean
) {
    Column(
        modifier = modifier.padding(if (isMobile) 8.sdp else 12.sdp),
        verticalArrangement = Arrangement.spacedBy(if (isMobile) 6.sdp else 8.sdp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(4.sdp)) {
            FlowRow(
                modifier = Modifier.wrapContentSize(),
                horizontalArrangement = Arrangement.spacedBy(5.sdp),
                verticalArrangement = Arrangement.spacedBy(5.sdp),
                maxLines = 1,
                maxItemsInEachRow = if (isMobile) 5 else 8
            ){
            tags.forEach { tag ->

                    Text(
                        text = tag,
                        fontSize = if (isMobile) 8.ssp else 5.ssp,
                        color = PrimaryPurple,
                        modifier = Modifier
                            .background(PrimaryPurple.copy(0.1f), RoundedCornerShape(5.sdp))
                            .padding(horizontal = 4.sdp, vertical = 2.sdp)
                    )
                }

            }
        }

        Text(
            text = title,
            fontSize = if (isMobile) 15.ssp else 10.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
            color = TextDark
        )

        Text(
            text = description,
            fontSize = if (isMobile) 9.ssp else 7.ssp,
            lineHeight = if (isMobile) 10.ssp else 10.ssp,
            color = TextLight,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Regular))
        )

        if (!isMobile) {
            points.forEach { point ->
                Row(verticalAlignment = Alignment.Top) {
                    Box(
                        modifier = Modifier.padding(top = 3.sdp).size(4.sdp)
                            .background(PrimaryPurple, RoundedCornerShape(50))
                    )
                    Spacer(modifier = Modifier.width(6.sdp))
                    Text(
                        text = point,
                        fontSize = 6.ssp,
                        color = TextLight,
                        fontFamily = FontFamily(Font(Res.font.Montserrat_Medium))
                    )
                }
            }
        }

        TextButton(
            onClick = onViewCaseStudy,
            contentPadding = PaddingValues(0.sdp),
            modifier = Modifier.heightIn(min = 24.sdp)
        ) {
            Text(
                "View Case Study →",
                fontSize = if (isMobile) 10.ssp else 7.ssp,
                color = PrimaryPurple,
                fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold))
            )
        }
    }
}

data class ProjectData (
    val projectName : String,
    val projectDescription :  String,
    val skillTags : List<String>,
    val impPoints : List<String>,
    val image : DrawableResource,
    val imageBackgroundColor : Color = Color.White,
    val isReversed: Boolean = false,
)


fun getProjectsData (): Array<ProjectData> {
    return arrayOf(
        ProjectData(
            projectName = "Musklr",
            projectDescription = "A comprehensive fitness ecosystem enabling gym owners to manage memberships while providing members with workout tracking and class booking.",
            skillTags = listOf(
                "Kotlin","jetpack Compose ","Compose Multiplatform","Koin","MVVM"
            ),
            impPoints = listOf(
                "Shared business logic using KMP for 40% faster development cycles.",
                "Real-time data synchronization."
            ),
            image =  Res.drawable.gym_login,
            imageBackgroundColor = Color(0xFFE5F1EF),
            isReversed = false
        ),
        ProjectData(
            projectName = "Loan Digit Partner / DSA",
            projectDescription = "Developed a loan management application for agents (DSA) to manage customer leads, track loan applications, and streamline onboarding processes.",

            skillTags = listOf("Android", "Jetpack Compose", "REST API","Retrofit","Hilt - Dagger","MVVM "),

            impPoints = listOf(
                "Implemented lead management system for handling customer data and loan applications.",
                "Integrated REST APIs to fetch and update real-time loan status.",
                "Built scalable UI using Jetpack Compose for smooth user experience.",
                "Optimized data handling and navigation for better performance."
            ),

            image = Res.drawable.gym_login,
            imageBackgroundColor = Color(0xFF1E3A3A),
            isReversed = true,
        ),
    )
}
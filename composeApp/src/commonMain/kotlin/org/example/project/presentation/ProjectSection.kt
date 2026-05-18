package org.example.project.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import myportfolio.composeapp.generated.resources.Montserrat_Bold
import myportfolio.composeapp.generated.resources.Montserrat_Medium
import myportfolio.composeapp.generated.resources.Montserrat_Regular
import myportfolio.composeapp.generated.resources.Montserrat_SemiBold
import myportfolio.composeapp.generated.resources.Res
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.PrimaryPurple
import org.example.project.ProjectData
import org.example.project.TextDark
import org.example.project.TextLight
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource


@Composable
fun ProjectSection(
    isMobile: Boolean,
    onViewCaseStudy: (String) -> Unit,
    projectData: List<ProjectData>
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = 12.sdp),
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


        projectData.forEach { project ->
            ProjectCard(
                isMobile = isMobile,
                title = project.projectName,
                description = project.projectDescription,
                tags = project.skillTags,
                points = project.impPoints,
                image = project.image,
                isReversed = project.isReversed,
                bgColor = project.imageBackgroundColor,
                onViewCaseStudy = { onViewCaseStudy(project.projectName) })
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
                ProjectDetails(
                    title,
                    description,
                    tags,
                    points,
                    Modifier.fillMaxWidth(),
                    onViewCaseStudy,
                    isMobile
                )
            }
        } else {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()) {
                if (isReversed) {
                    ProjectDetails(
                        title,
                        description,
                        tags,
                        points,
                        Modifier.weight(1.2f),
                        onViewCaseStudy,
                        isMobile
                    )
                    ProjectImage(image, bgColor, Modifier.weight(1f).height(180.sdp))
                } else {
                    ProjectImage(image, bgColor, Modifier.weight(1f).height(180.sdp))
                    ProjectDetails(
                        title,
                        description,
                        tags,
                        points,
                        Modifier.weight(1.2f),
                        onViewCaseStudy,
                        isMobile
                    )
                }
            }
        }
    }
}

@Composable
fun ProjectImage(
    image: org.jetbrains.compose.resources.DrawableResource,
    bgColor: Color,
    modifier: Modifier
) {
    Box(
        modifier = modifier.fillMaxHeight().background(bgColor, RoundedCornerShape(8.sdp))
            .padding(12.sdp), contentAlignment = Alignment.Center
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
            ) {
                tags.forEach { tag ->

                    Text(
                        text = tag,
                        fontSize = if (isMobile) 8.ssp else 5.ssp,
                        color = PrimaryPurple,
                        modifier = Modifier.background(
                                PrimaryPurple.copy(0.1f),
                                RoundedCornerShape(5.sdp)
                            ).padding(horizontal = 4.sdp, vertical = 2.sdp)
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

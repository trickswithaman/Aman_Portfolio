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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import myportfolio.composeapp.generated.resources.*
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProjectSection(isMobile: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 40.sdp)
    ) {
        Text(
            text = "Featured Projects",
            fontSize = if (isMobile) 16.ssp else 14.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
            color = TextDark
        )
        Text(
            text = "Real-world applications built with scalability and user experience in mind.",
            fontSize = if (isMobile) 8.ssp else 7.ssp,
            color = TextLight,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Medium)),
            modifier = Modifier.padding(bottom = 20.sdp)
        )

        ProjectCard(
            isMobile = isMobile,
            title = "Gym Management App",
            description = "A comprehensive fitness ecosystem enabling gym owners to manage memberships while providing members with workout tracking and class booking.",
            tags = listOf("KMP", "Compose Multiplatform", "Firebase"),
            points = listOf(
                "Shared business logic using KMP for 40% faster development cycles.",
                "Real-time data synchronization with Firebase Firestore."
            ),
            image = Res.drawable.ic_coding,
            bgColor = Color(0xFFE5F1EF)
        )

        Spacer(modifier = Modifier.height(20.sdp))

        ProjectCard(
            isMobile = isMobile,
            title = "The Catholic App",
            description = "A spiritual companion app featuring daily prayers, liturgical calendars, and community events with offline-first capabilities.",
            tags = listOf("Android", "Jetpack Compose", "SQLDelight"),
            points = listOf(
                "Optimized SQLDelight caching for seamless offline access.",
                "Custom UI components built purely with Jetpack Compose."
            ),
            image = Res.drawable.ic_coding,
            bgColor = Color(0xFF1E3A3A),
            isReversed = true
        )
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
    isReversed: Boolean = false
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = CardBg),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.sdp),
        shape = RoundedCornerShape(12.sdp),
        border = BorderStroke(0.5.sdp, lightGray)
    ) {
        if (isMobile) {
            Column {
                ProjectImage(image, bgColor, Modifier.fillMaxWidth().height(150.sdp))
                ProjectDetails(title, description, tags, points, Modifier.fillMaxWidth())
            }
        } else {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (isReversed) {
                    ProjectDetails(title, description, tags, points, Modifier.weight(1.2f))
                    ProjectImage(image, bgColor, Modifier.weight(1f).height(250.sdp))
                } else {
                    ProjectImage(image, bgColor, Modifier.weight(1f).height(250.sdp))
                    ProjectDetails(title, description, tags, points, Modifier.weight(1.2f))
                }
            }
        }
    }
}

@Composable
fun ProjectImage(image: org.jetbrains.compose.resources.DrawableResource, bgColor: Color, modifier: Modifier) {
    Box(
        modifier = modifier
            .background(bgColor, RoundedCornerShape(8.sdp))
            .padding(20.sdp),
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
fun ProjectDetails(title: String, description: String, tags: List<String>, points: List<String>, modifier: Modifier) {
    Column(
        modifier = modifier.padding(20.sdp),
        verticalArrangement = Arrangement.spacedBy(10.sdp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.sdp)) {
            tags.forEach { tag ->
                Text(
                    text = tag,
                    fontSize = 5.ssp,
                    color = PrimaryPurple,
                    modifier = Modifier
                        .background(PrimaryPurple.copy(0.05f), RoundedCornerShape(4.sdp))
                        .padding(horizontal = 6.sdp, vertical = 2.sdp)
                )
            }
        }

        Text(
            text = title,
            fontSize = 12.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
            color = TextDark
        )

        Text(
            text = description,
            fontSize = 7.ssp,
            lineHeight = 10.ssp,
            color = TextLight,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Regular))
        )

        points.forEach { point ->
            Row(verticalAlignment = Alignment.Top) {
                Box(modifier = Modifier.padding(top = 3.sdp).size(4.sdp).background(PrimaryPurple, RoundedCornerShape(50)))
                Spacer(modifier = Modifier.width(6.sdp))
                Text(
                    text = point,
                    fontSize = 6.ssp,
                    color = TextLight,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Medium))
                )
            }
        }

        TextButton(onClick = {}) {
            Text("View Case Study →", fontSize = 7.ssp, color = PrimaryPurple, fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold)))
        }
    }
}

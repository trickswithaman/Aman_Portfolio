package org.example.project.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import myportfolio.composeapp.generated.resources.Montserrat_Bold
import myportfolio.composeapp.generated.resources.Montserrat_Medium
import myportfolio.composeapp.generated.resources.Montserrat_Regular
import myportfolio.composeapp.generated.resources.Montserrat_SemiBold
import myportfolio.composeapp.generated.resources.Res
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AllProjectsScreen(
    isMobile: Boolean,
    onBack: () -> Unit = {},
    onViewCaseStudy: (String) -> Unit = {}
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize().background(BgColor)) {
        val horizontalPadding = if (isMobile) 15.sdp else maxWidth * 0.15f

        LazyVerticalGrid(
            columns = GridCells.Fixed(if (isMobile) 1 else 4),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                horizontal = horizontalPadding,
                vertical = 15.sdp
            ),
            horizontalArrangement = Arrangement.spacedBy(10.sdp),
            verticalArrangement = Arrangement.spacedBy(10.sdp)
        ) {
            // Header
            item(span = { GridItemSpan(maxLineSpan) }) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 10.sdp),
                    horizontalAlignment = Alignment.Start
                ) {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.padding(bottom = 4.sdp).size(14.sdp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = TextDark,
                            modifier = Modifier.size(10.sdp)
                        )
                    }

                    // Badge
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(PrimaryPurple.copy(alpha = 0.1f))
                            .padding(horizontal = 6.sdp, vertical = 2.sdp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(3.sdp)
                                .clip(CircleShape)
                                .background(PrimaryPurple)
                        )
                        Spacer(modifier = Modifier.width(3.sdp))
                        Text(
                            text = "PORTFOLIO 2026",
                            color = PrimaryPurple,
                            fontSize = if (isMobile) 6.ssp else 4.ssp,
                            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold))
                        )
                    }

                    Spacer(modifier = Modifier.height(8.sdp))

                    Text(
                        text = "All Projects",
                        fontSize = if (isMobile) 16.ssp else 20.ssp,
                        fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
                        color = TextDark
                    )

                    Spacer(modifier = Modifier.height(4.sdp))

                    Text(
                        text = "A collection of my work in mobile development, cross-platform engineering, and UI design. Exploring the boundaries of Kotlin Multiplatform and modern web technologies.",
                        fontSize = if (isMobile) 8.ssp else 6.ssp,
                        color = TextLight,
                        fontFamily = FontFamily(Font(Res.font.Montserrat_Medium)),
                        modifier = Modifier.widthIn(max = 750.dp),
                        lineHeight = if (isMobile) 10.ssp else 8.ssp
                    )
                }
            }

            // Project Cards
            items(PortfolioConstants.projects) { project ->
                PortfolioProjectCard(isMobile, project, onViewCaseStudy)
            }

            // CTA Section
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(15.sdp))
                CTASection(isMobile)
            }

            // Footer
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(modifier = Modifier.height(15.sdp))
                Footer(isMobile)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PortfolioProjectCard(
    isMobile: Boolean,
    project: ProjectData,
    onViewCaseStudy: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.sdp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.5.sdp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            // Image Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(if (isMobile) 100.sdp else 70.sdp)
                    .background(project.imageBackgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(project.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(0.5f),
                    contentScale = ContentScale.Fit
                )
            }

            Column(modifier = Modifier.padding(8.sdp)) {
                // Tags
                FlowRow(
                    maxLines = 2,
                    horizontalArrangement = Arrangement.spacedBy(3.sdp),
                    verticalArrangement = Arrangement.spacedBy(3.sdp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    project.skillTags.forEach { tag ->
                        Text(
                            text = tag,
                            modifier = Modifier
                                .clip(RoundedCornerShape(2.sdp))
                                .background(PrimaryPurple.copy(alpha = 0.08f))
                                .padding(horizontal = 3.sdp, vertical = 1.sdp),
                            fontSize = if (isMobile) 5.ssp else 4.ssp,
                            color = PrimaryPurple,
                            fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold))
                        )
                    }
                }

                Spacer(modifier = Modifier.height(6.sdp))

                Text(
                    text = project.projectName,
                    fontSize = if (isMobile) 10.ssp else 7.ssp,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
                    color = TextDark,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(3.sdp))

                Text(
                    text = project.projectDescription,
                    fontSize = if (isMobile) 7.ssp else 5.ssp,
                    color = TextLight,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Regular)),
                    lineHeight = if (isMobile) 8.ssp else 7.ssp,
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(8.sdp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { onViewCaseStudy(project.projectName) }
                ) {
                    Text(
                        text = "View Case Study",
                        fontSize = if (isMobile) 7.ssp else 5.ssp,
                        color = PrimaryPurple,
                        fontFamily = FontFamily(Font(Res.font.Montserrat_Bold))
                    )
                    Spacer(modifier = Modifier.width(2.sdp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = PrimaryPurple,
                        modifier = Modifier.size(if (isMobile) 7.sdp else 5.sdp)
                    )
                }
            }
        }
    }
}

@Composable
fun CTASection(isMobile: Boolean) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = PrimaryPurple),
        shape = RoundedCornerShape(10.sdp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.sdp, horizontal = 10.sdp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.sdp)
        ) {
            Text(
                text = "Have a project in mind?",
                fontSize = if (isMobile) 14.ssp else 16.ssp,
                color = Color.White,
                fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
                textAlign = TextAlign.Center
            )

            Text(
                text = "I'm currently available for freelance work and technical consulting. Let's build something amazing together.",
                fontSize = if (isMobile) 8.ssp else 6.ssp,
                color = Color.White.copy(alpha = 0.9f),
                fontFamily = FontFamily(Font(Res.font.Montserrat_Medium)),
                textAlign = TextAlign.Center,
                modifier = Modifier.widthIn(max = 300.dp),
                lineHeight = if (isMobile) 10.ssp else 8.ssp
            )

            Spacer(modifier = Modifier.height(4.sdp))

            Button(
                onClick = { /* Handle Let's Talk */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(4.sdp),
                contentPadding = PaddingValues(horizontal = 12.sdp, vertical = 6.sdp)
            ) {
                Text(
                    text = "Let's Talk",
                    fontSize = if (isMobile) 8.ssp else 6.ssp,
                    color = PrimaryPurple,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Bold))
                )
            }
        }
    }
}
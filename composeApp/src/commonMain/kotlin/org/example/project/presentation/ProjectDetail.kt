package org.example.project.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import myportfolio.composeapp.generated.resources.*
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProjectDetail(isMobile: Boolean, onBack: () -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(BgColor)
    ) {
        item {
            ProjectHero(isMobile, onBack)
            ProblemSection(isMobile)
            ArchitectureSection(isMobile)
            KeyFeaturesSection(isMobile)
            DesignSection(isMobile)
            ChallengesSection(isMobile)
            StatsSection(isMobile)
            ProjectNavigation(isMobile)
            ContactSection()
        }
    }
}

@Composable
fun ProjectHero(isMobile: Boolean, onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 20.sdp)) {
        TextButton(onClick = onBack, modifier = Modifier.padding(bottom = 10.sdp)) {
            Text("← Back to Projects", fontSize = 7.ssp, color = PrimaryPurple)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(10.sdp)) {
                Surface(
                    color = PrimaryPurple.copy(0.1f),
                    shape = RoundedCornerShape(20.sdp)
                ) {
                    Text(
                        "CASE STUDY",
                        modifier = Modifier.padding(horizontal = 8.sdp, vertical = 4.sdp),
                        fontSize = 5.ssp,
                        color = PrimaryPurple,
                        fontFamily = FontFamily(Font(Res.font.Montserrat_Bold))
                    )
                }

                Text(
                    text = "Gym Management\nEcosystem",
                    fontSize = 24.ssp,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Black)),
                    color = TextDark,
                    lineHeight = 28.ssp
                )

                Text(
                    text = "A cross-platform SaaS solution built with Kotlin Multiplatform to streamline gym operations, member engagement, and staff management across Android, iOS, and Web.",
                    fontSize = 8.ssp,
                    color = TextLight,
                    lineHeight = 12.ssp
                )

                FlowRow(horizontalArrangement = Arrangement.spacedBy(6.sdp)) {
                    val tags = listOf("KMP", "Compose", "Firebase", "MVI", "Ktor")
                    tags.forEach { tag ->
                        Surface(
                            color = lightGray.copy(0.3f),
                            shape = RoundedCornerShape(4.sdp),
                            border = BorderStroke(0.5.sdp, lightGray)
                        ) {
                            Text(
                                tag,
                                modifier = Modifier.padding(horizontal = 6.sdp, vertical = 2.sdp),
                                fontSize = 5.ssp,
                                color = TextDark
                            )
                        }
                    }
                }

                Row(horizontalArrangement = Arrangement.spacedBy(10.sdp)) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryPurple),
                        shape = RoundedCornerShape(8.sdp)
                    ) {
                        Text("APP FRONT", fontSize = 7.ssp)
                    }
                    OutlinedButton(
                        onClick = {},
                        shape = RoundedCornerShape(8.sdp),
                        border = BorderStroke(1.sdp, lightGray)
                    ) {
                        Text("VIEW REPO", fontSize = 7.ssp, color = TextDark)
                    }
                }
            }

            Spacer(modifier = Modifier.width(20.sdp))

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(250.sdp)
                    .background(Color(0xFFFDE2E4), RoundedCornerShape(20.sdp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_coding),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(0.8f),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@Composable
fun ProblemSection(isMobile: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 40.sdp),
        horizontalArrangement = Arrangement.spacedBy(40.sdp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Box(modifier = Modifier.width(30.sdp).height(3.sdp).background(PrimaryPurple))
            Spacer(modifier = Modifier.height(10.sdp))
            Text(
                "The Problem",
                fontSize = 14.ssp,
                fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
                color = TextDark
            )
        }
        Text(
            text = "Traditional gym management systems are often fragmented, relying on separate tools for member tracking, billing, and scheduling. This creates data silos and operational friction. Gym owners needed a unified ecosystem that provides a seamless experience for both staff on desktops and members on mobile devices, while minimizing development costs for multiple platforms.",
            modifier = Modifier.weight(2.5f),
            fontSize = 8.ssp,
            lineHeight = 14.ssp,
            color = TextLight
        )
    }
}

@Composable
fun ArchitectureSection(isMobile: Boolean) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 40.sdp)) {
        Text(
            "Architecture & Approach",
            fontSize = 14.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
            color = TextDark,
            modifier = Modifier.padding(bottom = 20.sdp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(250.sdp)
                    .background(CardBg, RoundedCornerShape(12.sdp))
                    .border(BorderStroke(0.5.sdp, lightGray), RoundedCornerShape(12.sdp)),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(painterResource(Res.drawable.container), null, modifier = Modifier.size(40.sdp), tint = PrimaryPurple)
                    Text("ARCHITECTURE DIAGRAM", fontSize = 6.ssp, color = TextLight)
                }
            }

            Spacer(modifier = Modifier.width(40.sdp))

            Column(modifier = Modifier.weight(1.2f), verticalArrangement = Arrangement.spacedBy(15.sdp)) {
                ArchitectureItem("KMP Shared Logic", "Shared business logic, network models, and data persistence across all platforms using Kotlin Multiplatform.")
                ArchitectureItem("MVI Pattern", "Predictable state management for complex UIs, ensuring consistent behavior across Android and iOS.")
                ArchitectureItem("Dependency Injection", "Leveraging Koin for lightweight, multiplatform-friendly dependency injection.")
                ArchitectureItem("Firebase Integration", "Real-time database and authentication synchronized across mobile and web clients.")
            }
        }
    }
}

@Composable
fun ArchitectureItem(title: String, desc: String) {
    Row(verticalAlignment = Alignment.Top) {
        Box(modifier = Modifier.size(16.sdp).background(PrimaryPurple.copy(0.1f), RoundedCornerShape(4.sdp)), contentAlignment = Alignment.Center) {
            Icon(painterResource(Res.drawable.ic_download), null, modifier = Modifier.size(10.sdp), tint = PrimaryPurple)
        }
        Spacer(modifier = Modifier.width(12.sdp))
        Column {
            Text(title, fontSize = 8.ssp, fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)), color = TextDark)
            Text(desc, fontSize = 7.ssp, color = TextLight, lineHeight = 10.ssp)
        }
    }
}

@Composable
fun KeyFeaturesSection(isMobile: Boolean) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 40.sdp)) {
        Text(
            "Key Features",
            modifier = Modifier.fillMaxWidth().padding(bottom = 30.sdp),
            textAlign = TextAlign.Center,
            fontSize = 14.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
            color = TextDark
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.sdp),
            verticalArrangement = Arrangement.spacedBy(15.sdp)
        ) {
            FeatureCard("Attendance Tracking", "QR based check-in and real-time attendance dashboards for managers.", Modifier.weight(1f))
            FeatureCard("Subscriptions", "Automated billing, renewal reminders, and multiple membership tier support.", Modifier.weight(1f))
            FeatureCard("Role Based Access", "Different UI and permissions for Owners, Staff, and Members.", Modifier.weight(1f))
            FeatureCard("Cross-Platform", "Seamless experience across Android, iOS, and Web with 100% shared logic.", Modifier.weight(1f))
        }
    }
}

@Composable
fun FeatureCard(title: String, desc: String, modifier: Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = CardBg),
        border = BorderStroke(0.5.sdp, lightGray),
        shape = RoundedCornerShape(8.sdp)
    ) {
        Column(modifier = Modifier.padding(16.sdp), verticalArrangement = Arrangement.spacedBy(8.sdp)) {
            Icon(painterResource(Res.drawable.ic_download), null, modifier = Modifier.size(16.sdp), tint = PrimaryPurple)
            Text(title, fontSize = 8.ssp, fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)), color = TextDark)
            Text(desc, fontSize = 7.ssp, color = TextLight, lineHeight = 10.ssp)
        }
    }
}

@Composable
fun DesignSection(isMobile: Boolean) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 40.sdp)) {
        Text(
            "Experience Design",
            fontSize = 14.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
            color = TextDark,
            modifier = Modifier.padding(bottom = 20.sdp)
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(15.sdp)) {
            DesignMockup("Login & Onboarding", Color(0xFF1E1B4B), Modifier.weight(1f))
            DesignMockup("Member Dashboard", Color(0xFFFFFAF0), Modifier.weight(1f))
            DesignMockup("Staff Management", Color(0xFFF3F4F6), Modifier.weight(1f))
        }
    }
}

@Composable
fun DesignMockup(title: String, bgColor: Color, modifier: Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.sdp)
                .background(bgColor, RoundedCornerShape(12.sdp))
                .border(BorderStroke(0.5.sdp, lightGray), RoundedCornerShape(12.sdp))
        )
        Spacer(modifier = Modifier.height(10.sdp))
        Text(title, fontSize = 6.ssp, color = TextLight, fontFamily = FontFamily(Font(Res.font.Montserrat_Medium)))
    }
}

@Composable
fun ChallengesSection(isMobile: Boolean) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 40.sdp)) {
        Text(
            "Challenges & Solutions",
            fontSize = 14.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
            color = TextDark,
            modifier = Modifier.padding(bottom = 20.sdp)
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(15.sdp)) {
            ChallengeCard("CHALLENGE", "Platform-Specific UI Differences", "Ensuring a cohesive brand experience while respecting the UX paradigms of both Android (Material) and iOS (Cupertino).", Modifier.weight(1f))
            ChallengeCard("SOLUTION", "Design System Tokens", "Implemented a shared design system with shared colors and typography, but platform-specific navigation and component behaviors.", Modifier.weight(1f))
        }
    }
}

@Composable
fun ChallengeCard(tag: String, title: String, desc: String, modifier: Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = if (tag == "CHALLENGE") Color(0xFFFEF2F2) else Color(0xFFF0F9FF)),
        shape = RoundedCornerShape(8.sdp)
    ) {
        Column(modifier = Modifier.padding(16.sdp), verticalArrangement = Arrangement.spacedBy(8.sdp)) {
            Text(tag, fontSize = 5.ssp, color = if (tag == "CHALLENGE") Color.Red else PrimaryPurple, fontWeight = FontWeight.Bold)
            Text(title, fontSize = 9.ssp, fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)), color = TextDark)
            Text(desc, fontSize = 7.ssp, color = TextLight, lineHeight = 11.ssp)
        }
    }
}

@Composable
fun StatsSection(isMobile: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 60.sdp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        StatItem("70%", "Shared Codebase", "Across 3 platforms, significantly reducing development and bug fixing.")
        StatItem("40%", "Development Speed", "Improved time-to-market for new features using shared business logic.")
        StatItem("MVI", "Maintainability", "Simplified debugging through a unidirectional data flow and clear state.")
    }
}

@Composable
fun StatItem(valStr: String, title: String, desc: String) {
    Column(modifier = Modifier.width(100.sdp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(valStr, fontSize = 24.ssp, color = PrimaryPurple, fontFamily = FontFamily(Font(Res.font.Montserrat_Black)))
        Text(title, fontSize = 9.ssp, fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)), color = TextDark)
        Text(desc, fontSize = 6.ssp, color = TextLight, textAlign = TextAlign.Center, lineHeight = 8.ssp)
    }
}

@Composable
fun ProjectNavigation(isMobile: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 40.sdp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextButton(onClick = {}) {
            Text("← PREVIOUS PROJECT\nFintech Dashboard", fontSize = 7.ssp, color = TextLight)
        }
        TextButton(onClick = {}, modifier = Modifier.align(Alignment.Bottom)) {
            Text("NEXT PROJECT →\nAthletic Tracker", fontSize = 7.ssp, color = TextLight, textAlign = TextAlign.End)
        }
    }
}

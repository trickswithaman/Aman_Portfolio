package org.example.project.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
            if (!isMobile) {
                ProjectNavigation(isMobile)
            }
        }
    }
}

@Composable
fun ProjectHero(isMobile: Boolean, onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 20.sdp)) {
        TextButton(onClick = onBack, modifier = Modifier.padding(bottom = 10.sdp)) {
            Text("← Back to Projects", fontSize = 7.ssp, color = PrimaryPurple)
        }

        if (isMobile) {
            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(15.sdp)) {
                HeroContent(isMobile)
                HeroImage(isMobile)
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(1.2f)) {
                    HeroContent(isMobile)
                }
                Spacer(modifier = Modifier.width(20.sdp))
                Box(modifier = Modifier.weight(1f)) {
                    HeroImage(isMobile)
                }
            }
        }
    }
}

@Composable
fun HeroContent(isMobile: Boolean) {
    Column(verticalArrangement = Arrangement.spacedBy(if (isMobile) 10.sdp else 8.sdp)) {
        Surface(
            color = PrimaryPurple.copy(0.1f),
            shape = RoundedCornerShape(20.sdp)
        ) {
            Text(
                "CASE STUDY",
                modifier = Modifier.padding(horizontal = 8.sdp, vertical = 4.sdp),
                fontSize = if (isMobile) 7.ssp else 4.ssp,
                color = PrimaryPurple,
                fontFamily = FontFamily(Font(Res.font.Montserrat_Bold))
            )
        }

        Text(
            text = "Musklr Gym\nManagement System",
            fontSize = if (isMobile) 22.ssp else 16.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Black)),
            color = TextDark,
            lineHeight = if (isMobile) 26.ssp else 20.ssp
        )

        Text(
            text = "A cross-platform SaaS solution built with Kotlin Multiplatform to streamline gym operations, member engagement, and staff management across Android, iOS, and Web.",
            fontSize = if (isMobile) 10.ssp else 6.5.ssp,
            color = TextLight,
            lineHeight = if (isMobile) 14.ssp else 10.ssp
        )

        FlowRow(horizontalArrangement = Arrangement.spacedBy(6.sdp)) {
            val tags = listOf("KMP", "Compose Multiplatform", "Firebase", "MVI", "Ktor", "Koin")
            tags.forEach { tag ->
                Surface(
                    color = lightGray.copy(0.3f),
                    shape = RoundedCornerShape(4.sdp),
                    border = BorderStroke(0.5.sdp, lightGray)
                ) {
                    Text(
                        tag,
                        modifier = Modifier.padding(horizontal = 6.sdp, vertical = 2.sdp),
                        fontSize = if (isMobile) 7.ssp else 4.ssp,
                        color = TextDark
                    )
                }
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(10.sdp)) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryPurple),
                shape = RoundedCornerShape(8.sdp),
                contentPadding = if (isMobile) ButtonDefaults.ContentPadding else PaddingValues(horizontal = 12.sdp, vertical = 6.sdp)
            ) {
                Text("LIVE DEMO", fontSize = if (isMobile) 9.ssp else 6.ssp)
            }
            OutlinedButton(
                onClick = {},
                shape = RoundedCornerShape(8.sdp),
                border = BorderStroke(1.sdp, lightGray),
                contentPadding = if (isMobile) ButtonDefaults.ContentPadding else PaddingValues(horizontal = 12.sdp, vertical = 6.sdp)
            ) {
                Text("VIEW REPO", fontSize = if (isMobile) 9.ssp else 6.ssp, color = TextDark)
            }
        }
    }
}

@Composable
fun HeroImage(isMobile: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(if (isMobile) 250.sdp else 180.sdp)
            .background(Color(0xFFE5F1EF), RoundedCornerShape(20.sdp)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.gym_login),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(0.9f),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun ProblemSection(isMobile: Boolean) {
    if (isMobile) {
        Column(modifier = Modifier.fillMaxWidth().padding(vertical = 20.sdp)) {
            Box(modifier = Modifier.width(30.sdp).height(3.sdp).background(PrimaryPurple))
            Spacer(modifier = Modifier.height(10.sdp))
            Text(
                "The Problem",
                fontSize = 12.ssp,
                fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
                color = TextDark
            )
            Spacer(modifier = Modifier.height(10.sdp))
            Text(
                text = "Traditional gym management systems are often fragmented, relying on separate tools for member tracking, billing, and scheduling. This creates data silos and operational friction. Gym owners needed a unified ecosystem that provides a seamless experience for both staff on desktops and members on mobile devices, while minimizing development costs for multiple platforms.",
                fontSize = 8.ssp,
                lineHeight = 12.ssp,
                color = TextLight
            )
        }
    } else {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 40.sdp),
            horizontalArrangement = Arrangement.spacedBy(40.sdp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Box(modifier = Modifier.width(30.sdp).height(3.sdp).background(PrimaryPurple))
                Spacer(modifier = Modifier.height(10.sdp))
                Text(
                    "The Problem",
                    fontSize = 12.ssp,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
                    color = TextDark
                )
            }
            Text(
                text = "Traditional gym management systems are often fragmented, relying on separate tools for member tracking, billing, and scheduling. This creates data silos and operational friction. Gym owners needed a unified ecosystem that provides a seamless experience for both staff on desktops and members on mobile devices, while minimizing development costs for multiple platforms.",
                modifier = Modifier.weight(2.5f),
                fontSize = 7.ssp,
                lineHeight = 12.ssp,
                color = TextLight
            )
        }
    }
}

@Composable
fun ArchitectureSection(isMobile: Boolean) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = if (isMobile) 40.sdp else 20.sdp)) {
        Text(
            "Architecture & Approach",
            fontSize = if (isMobile) 16.ssp else 12.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
            color = TextDark,
            modifier = Modifier.padding(bottom = 20.sdp)
        )

        if (isMobile) {
            Column(verticalArrangement = Arrangement.spacedBy(25.sdp)) {
                ArchitectureItems(isMobile)
                ArchitectureDiagram(isMobile)
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    ArchitectureDiagram(isMobile)
                }
                Spacer(modifier = Modifier.width(40.sdp))
                Box(modifier = Modifier.weight(1.2f)) {
                    ArchitectureItems(isMobile)
                }
            }
        }
    }
}

@Composable
fun ArchitectureDiagram(isMobile: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(if (isMobile) 200.sdp else 140.sdp)
            .background(CardBg, RoundedCornerShape(12.sdp))
            .border(BorderStroke(0.5.sdp, lightGray), RoundedCornerShape(12.sdp)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(painterResource(Res.drawable.container), null, modifier = Modifier.size(if (isMobile) 40.sdp else 30.sdp), tint = PrimaryPurple)
            Text("ARCHITECTURE: MVI + CLEAN", fontSize = if (isMobile) 6.ssp else 5.ssp, color = TextLight)
        }
    }
}

@Composable
fun ArchitectureItems(isMobile: Boolean) {
    Column(verticalArrangement = Arrangement.spacedBy(if (isMobile) 15.sdp else 10.sdp)) {
        ArchitectureItem("Clean Architecture", "Structured into Core, Data, Domain, and Presentation layers for maximum decoupling and scalability.", isMobile)
        ArchitectureItem("MVI Pattern", "Predictable state management using Model-View-Intent with a shared BaseViewModel across KMP.", isMobile)
        ArchitectureItem("Use Case Driven", "Domain logic encapsulated in specialized UseCases, making the business layer testable and modular.", isMobile)
        ArchitectureItem("Koin DI & Ktor", "Lightweight dependency injection and modern asynchronous networking for a seamless multiplatform experience.", isMobile)
    }
}

@Composable
fun ArchitectureItem(title: String, desc: String, isMobile: Boolean) {
    Row(verticalAlignment = Alignment.Top) {
        Box(modifier = Modifier.size(if (isMobile) 16.sdp else 14.sdp).background(PrimaryPurple.copy(0.1f), RoundedCornerShape(4.sdp)), contentAlignment = Alignment.Center) {
            Icon(painterResource(Res.drawable.ic_download), null, modifier = Modifier.size(if (isMobile) 10.sdp else 8.sdp), tint = PrimaryPurple)
        }
        Spacer(modifier = Modifier.width(if (isMobile) 12.sdp else 10.sdp))
        Column {
            Text(title, fontSize = if (isMobile) 8.ssp else 7.ssp, fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)), color = TextDark)
            Text(desc, fontSize = if (isMobile) 7.ssp else 6.ssp, color = TextLight, lineHeight = if (isMobile) 10.ssp else 8.ssp)
        }
    }
}

@Composable
fun KeyFeaturesSection(isMobile: Boolean) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = if (isMobile) 40.sdp else 20.sdp)) {
        Text(
            "Key Features",
            modifier = Modifier.fillMaxWidth().padding(bottom = 30.sdp),
            textAlign = TextAlign.Center,
            fontSize = if (isMobile) 16.ssp else 12.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
            color = TextDark
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.sdp),
            verticalArrangement = Arrangement.spacedBy(15.sdp)
        ) {
            FeatureCard("Attendance Tracking", "QR based check-in and real-time attendance dashboards for managers.", isMobile, Modifier.weight(1f))
            FeatureCard("Subscriptions", "Automated billing, renewal reminders, and multiple membership tier support.", isMobile, Modifier.weight(1f))
            FeatureCard("Role Based Access", "Different UI and permissions for Owners, Staff, and Members.", isMobile, Modifier.weight(1f))
            FeatureCard("Cross-Platform", "Seamless experience across Android, iOS, and Web with 100% shared logic.", isMobile, Modifier.weight(1f))
        }
    }
}

@Composable
fun FeatureCard(title: String, desc: String, isMobile: Boolean, modifier: Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = CardBg),
        border = BorderStroke(0.5.sdp, lightGray),
        shape = RoundedCornerShape(8.sdp)
    ) {
        Column(modifier = Modifier.padding(if (isMobile) 16.sdp else 12.sdp), verticalArrangement = Arrangement.spacedBy(if (isMobile) 8.sdp else 6.sdp)) {
            Icon(painterResource(Res.drawable.ic_download), null, modifier = Modifier.size(if (isMobile) 16.sdp else 14.sdp), tint = PrimaryPurple)
            Text(title, fontSize = if (isMobile) 8.ssp else 7.ssp, fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)), color = TextDark)
            Text(desc, fontSize = if (isMobile) 7.ssp else 6.ssp, color = TextLight, lineHeight = if (isMobile) 10.ssp else 8.ssp)
        }
    }
}

@Composable
fun DesignSection(isMobile: Boolean) {
    val mockups = listOf(
        Pair("Sign In Screen", Res.drawable.gym_login),
        Pair("OTP Verification", Res.drawable.gym_otp),
        Pair("Member Registration", Res.drawable.gym_register_members),
        Pair("Plan Selection", Res.drawable.gum_select_package),
        Pair("Coach Directory", Res.drawable.gym_coach_list),
        Pair("Member Directory", Res.drawable.gym_member_list)
    )

    Column(modifier = Modifier.fillMaxWidth().padding(vertical = if (isMobile) 40.sdp else 20.sdp)) {
        Text(
            "Experience Design",
            fontSize = if (isMobile) 16.ssp else 12.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
            color = TextDark,
            modifier = Modifier.padding(bottom = 20.sdp)
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(if (isMobile) 15.sdp else 10.sdp),
            contentPadding = PaddingValues(horizontal = 2.sdp)
        ) {
            items(mockups) { mockup ->
                DesignMockup(
                    title = mockup.first,
                    image = mockup.second,
                    modifier = Modifier.width(if (isMobile) 120.sdp else 100.sdp),
                    isMobile = isMobile
                )
            }
        }
    }
}

@Composable
fun DesignMockup(title: String, image: org.jetbrains.compose.resources.DrawableResource, modifier: Modifier, isMobile: Boolean) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(if (isMobile) 250.sdp else 210.sdp),
            shape = RoundedCornerShape(12.sdp),
            border = BorderStroke(0.5.sdp, lightGray),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.sdp)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }
        Spacer(modifier = Modifier.height(10.sdp))
        Text(title, fontSize = 7.ssp, color = TextLight, fontFamily = FontFamily(Font(Res.font.Montserrat_Medium)))
    }
}

@Composable
fun ChallengesSection(isMobile: Boolean) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = if (isMobile) 40.sdp else 20.sdp)) {
        Text(
            "Challenges & Solutions",
            fontSize = if (isMobile) 16.ssp else 12.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
            color = TextDark,
            modifier = Modifier.padding(bottom = 20.sdp)
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(if (isMobile) 15.sdp else 10.sdp)) {
            ChallengeCard("CHALLENGE", "Platform-Specific UI Differences", "Ensuring a cohesive brand experience while respecting the UX paradigms of both Android (Material) and iOS (Cupertino).", isMobile, Modifier.weight(1f))
            ChallengeCard("SOLUTION", "Design System Tokens", "Implemented a shared design system with shared colors and typography, but platform-specific navigation and component behaviors.", isMobile, Modifier.weight(1f))
        }
    }
}

@Composable
fun ChallengeCard(tag: String, title: String, desc: String, isMobile: Boolean, modifier: Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = if (tag == "CHALLENGE") Color(0xFFFEF2F2) else Color(0xFFF0F9FF)),
        shape = RoundedCornerShape(8.sdp)
    ) {
        Column(modifier = Modifier.padding(if (isMobile) 16.sdp else 12.sdp), verticalArrangement = Arrangement.spacedBy(if (isMobile) 8.sdp else 6.sdp)) {
            Text(tag, fontSize = if (isMobile) 5.ssp else 4.ssp, color = if (tag == "CHALLENGE") Color.Red else PrimaryPurple, fontWeight = FontWeight.Bold)
            Text(title, fontSize = if (isMobile) 9.ssp else 8.ssp, fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)), color = TextDark)
            Text(desc, fontSize = if (isMobile) 7.ssp else 6.ssp, color = TextLight, lineHeight = if (isMobile) 11.ssp else 9.ssp)
        }
    }
}

@Composable
fun StatsSection(isMobile: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = if (isMobile) 60.sdp else 30.sdp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        StatItem("70%", "Shared Codebase", "Across 3 platforms, significantly reducing development and bug fixing.", isMobile)
        StatItem("40%", "Development Speed", "Improved time-to-market for new features using shared business logic.", isMobile)
        StatItem("MVI", "Maintainability", "Simplified debugging through a unidirectional data flow and clear state.", isMobile)
    }
}

@Composable
fun StatItem(valStr: String, title: String, desc: String, isMobile: Boolean) {
    Column(modifier = Modifier.width(if (isMobile) 100.sdp else 80.sdp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(valStr, fontSize = if (isMobile) 26.ssp else 18.ssp, color = PrimaryPurple, fontFamily = FontFamily(Font(Res.font.Montserrat_Black)))
        Text(title, fontSize = if (isMobile) 11.ssp else 8.ssp, fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)), color = TextDark)
        Text(desc, fontSize = if (isMobile) 8.ssp else 5.ssp, color = TextLight, textAlign = TextAlign.Center, lineHeight = if (isMobile) 10.ssp else 7.ssp)
    }
}

@Composable
fun ProjectNavigation(isMobile: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = if (isMobile) 40.sdp else 20.sdp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextButton(onClick = {}) {
            Text("← PREVIOUS PROJECT\nFintech Dashboard", fontSize = if (isMobile) 9.ssp else 6.ssp, color = TextLight)
        }
        TextButton(onClick = {}, modifier = Modifier.align(Alignment.Bottom)) {
            Text("NEXT PROJECT →\nAthletic Tracker", fontSize = if (isMobile) 9.ssp else 6.ssp, color = TextLight, textAlign = TextAlign.End)
        }
    }
}

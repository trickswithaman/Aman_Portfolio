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
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProjectDetail(isMobile: Boolean, data: CaseStudyData, onBack: () -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(BgColor)
    ) {
        item {
            ProjectHero(isMobile, onBack, data)
            ProblemSection(isMobile, data)
            ArchitectureSection(isMobile, data)
            KeyFeaturesSection(isMobile, data)
            DesignSection(isMobile, data)
            ChallengesSection(isMobile, data)
            StatsSection(isMobile, data)
        }
    }
}

@Composable
fun ProjectHero(isMobile: Boolean, onBack: () -> Unit, data: CaseStudyData) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 20.sdp)) {
        TextButton(onClick = onBack, modifier = Modifier.padding(bottom = 10.sdp)) {
            Text("← Back to Projects", fontSize = 7.ssp, color = PrimaryPurple)
        }

        if (isMobile) {
            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(15.sdp)) {
                HeroContent(isMobile, data)
                HeroImage(isMobile, data)
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(1.2f)) {
                    HeroContent(isMobile, data)
                }
                Spacer(modifier = Modifier.width(20.sdp))
                Box(modifier = Modifier.weight(1f)) {
                    HeroImage(isMobile, data)
                }
            }
        }
    }
}

@Composable
fun HeroContent(isMobile: Boolean, data: CaseStudyData) {
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
            text = data.title,
            fontSize = if (isMobile) 22.ssp else 16.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Black)),
            color = TextDark,
            lineHeight = if (isMobile) 26.ssp else 20.ssp
        )

        Text(
            text = data.description,
            fontSize = if (isMobile) 10.ssp else 6.5.ssp,
            color = TextLight,
            lineHeight = if (isMobile) 14.ssp else 10.ssp
        )

        FlowRow(horizontalArrangement = Arrangement.spacedBy(6.sdp), verticalArrangement = Arrangement.spacedBy(5.sdp)) {
            data.tags.forEach { tag ->
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
fun HeroImage(isMobile: Boolean, data: CaseStudyData) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(if (isMobile) 250.sdp else 180.sdp)
            .background(data.heroBgColor, RoundedCornerShape(20.sdp)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(data.heroImage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(0.9f),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun ProblemSection(isMobile: Boolean, data: CaseStudyData) {
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
                text = data.problem,
                fontSize = 10.ssp,
                lineHeight = 14.ssp,
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
                text = data.problem,
                modifier = Modifier.weight(2.5f),
                fontSize = 7.ssp,
                lineHeight = 12.ssp,
                color = TextLight
            )
        }
    }
}

@Composable
fun ArchitectureSection(isMobile: Boolean, data: CaseStudyData) {
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
                ArchitectureItems(isMobile, data)
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
                    ArchitectureItems(isMobile, data)
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
fun ArchitectureItems(isMobile: Boolean, data: CaseStudyData) {
    Column(verticalArrangement = Arrangement.spacedBy(if (isMobile) 15.sdp else 10.sdp)) {
        data.architectureItems.forEach { (title, desc) ->
            ArchitectureItem(title, desc, isMobile)
        }
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
fun KeyFeaturesSection(isMobile: Boolean, data: CaseStudyData) {
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
            data.features.forEach { (title, desc) ->
                FeatureCard(title, desc, isMobile, Modifier.weight(1f))
            }
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
fun DesignSection(isMobile: Boolean, data: CaseStudyData) {
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
            items(data.mockups) { mockup ->
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
fun DesignMockup(title: String, image: DrawableResource, modifier: Modifier, isMobile: Boolean) {
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
fun ChallengesSection(isMobile: Boolean, data: CaseStudyData) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = if (isMobile) 40.sdp else 20.sdp)) {
        Text(
            "Challenges & Solutions",
            fontSize = if (isMobile) 16.ssp else 12.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
            color = TextDark,
            modifier = Modifier.padding(bottom = 20.sdp)
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(if (isMobile) 15.sdp else 10.sdp)) {
            data.challenges.forEach { (title, desc) ->
                ChallengeCard("CHALLENGE", title, desc, isMobile, Modifier.weight(1f))
            }
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
            Text(tag, fontSize = if (isMobile) 7.ssp else 4.ssp, color = if (tag == "CHALLENGE") Color.Red else PrimaryPurple, fontWeight = FontWeight.Bold)
            Text(title, fontSize = if (isMobile) 11.ssp else 8.ssp, fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)), color = TextDark)
            Text(desc, fontSize = if (isMobile) 9.ssp else 6.ssp, color = TextLight, lineHeight = if (isMobile) 11.ssp else 9.ssp)
        }
    }
}

@Composable
fun StatsSection(isMobile: Boolean, data: CaseStudyData) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = if (isMobile) 60.sdp else 30.sdp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        data.stats.forEach { (value, title, desc) ->
            StatItem(value, title, desc, isMobile)
        }
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

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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import myportfolio.composeapp.generated.resources.*
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun TopSection(isMobile: Boolean) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = 20.sdp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isMobile) {
            Column(modifier = Modifier.fillMaxWidth()) {
                LeftBox(isMobile = true)
                Spacer(modifier = Modifier.height(20.sdp))
                CodeSnippetWindow(modifier = Modifier.fillMaxWidth())
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    LeftBox(isMobile = false)
                }
                Spacer(modifier = Modifier.width(20.sdp))
                Box(modifier = Modifier.weight(1f)) {
                    CodeSnippetWindow(modifier = Modifier.fillMaxWidth())
                }
            }
        }

        Spacer(modifier = Modifier.height(30.sdp))

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.sdp),
            verticalArrangement = Arrangement.spacedBy(10.sdp)
        ) {
            val cardModifier = if (isMobile) Modifier.fillMaxWidth(0.47f) else Modifier.weight(1f)
            MyCard(
                modifier = cardModifier,
                isMobile = isMobile,
                headingText = "Experience",
                description = "1.5+ Years",
                icon = Res.drawable.ic_download
            )
            MyCard(
                modifier = cardModifier,
                isMobile = isMobile,
                headingText = "Systems Delivered",
                description = "10+ Production",
                icon = Res.drawable.ic_download
            )
            MyCard(
                modifier = cardModifier,
                isMobile = isMobile,
                headingText = "Specialist",
                description = "KMP & Compose",
                icon = Res.drawable.ic_download
            )
            MyCard(
                modifier = cardModifier,
                isMobile = isMobile,
                headingText = "Portfolio",
                description = "Cross-Platform",
                icon = Res.drawable.ic_download
            )
        }
    }
}

@Composable
fun LeftBox(isMobile: Boolean) {
    Column(
        modifier = Modifier.wrapContentSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.sdp)
    ) {
        Row(
            modifier = Modifier
                .background(PrimaryPurple.copy(alpha = 0.1f), RoundedCornerShape(20.sdp))
                .padding(horizontal = 8.sdp, vertical = 4.sdp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(4.sdp)
                    .background(PrimaryPurple, RoundedCornerShape(50))
            )
            Spacer(modifier = Modifier.width(4.sdp))
            Text(
                text = "AVAILABLE FOR NEW PROJECTS",
                fontSize = if (isMobile) 7.ssp else 5.ssp,
                fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold)),
                color = PrimaryPurple
            )
        }

        Text(
            text = buildAnnotatedString {
                append("Kotlin\n")
                withStyle(style = SpanStyle(color = PrimaryPurple)) {
                    append("Multiplatform\nEngineer")
                }
            },
            fontSize = if (isMobile) 24.ssp else 32.ssp,
            lineHeight = if (isMobile) 28.ssp else 36.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Black)),
            color = TextDark
        )

        Text(
            text = "Specializing in Compose and Clean Architecture to build high-performance, native-quality cross-platform applications that scale.",
            fontSize = if (isMobile) 10.ssp else 7.ssp,
            lineHeight = if (isMobile) 14.ssp else 11.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Medium)),
            color = TextLight,
            modifier = Modifier.padding(vertical = 8.sdp)
        )

        Row(
            modifier = Modifier.wrapContentSize(),
            horizontalArrangement = Arrangement.spacedBy(8.sdp)
        ) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryPurple),
                shape = RoundedCornerShape(8.sdp),
                contentPadding = PaddingValues(horizontal = 16.sdp, vertical = 8.sdp)
            ) {
                Text(
                    text = "View Projects",
                    fontSize = if (isMobile) 9.ssp else 6.ssp,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Bold))
                )
            }
            OutlinedButton(
                onClick = {},
                shape = RoundedCornerShape(8.sdp),
                border = BorderStroke(1.sdp, lightGray),
                contentPadding = PaddingValues(horizontal = 16.sdp, vertical = 8.sdp)
            ) {
                Text(
                    text = "Download Resume",
                    fontSize = if (isMobile) 9.ssp else 6.ssp,
                    color = TextDark,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Bold))
                )
            }
        }
    }
}

@Composable
fun CodeSnippetWindow(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.height(180.sdp),
        colors = CardDefaults.cardColors(containerColor = CardBg),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.sdp),
        shape = RoundedCornerShape(12.sdp)
    ) {
        Column(modifier = Modifier.padding(12.sdp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(4.sdp)) {
                Dot(Color(0xFFFF5F56))
                Dot(Color(0xFFFFBD2E))
                Dot(Color(0xFF27C93F))
            }
            Spacer(modifier = Modifier.height(12.sdp))
            CodeLine("val", " engineer", " = ", "Engineer(", color1 = Color(0xFFC678DD), color2 = Color(0xFFE06C75))
            CodeLine("    name = ", "\"Aman Saxena\"", ",", "", color1 = Color(0xFFD19A66), color2 = Color(0xFF98C379))
            CodeLine("    role = ", "\"KMP Expert\"", ",", "", color1 = Color(0xFFD19A66), color2 = Color(0xFF98C379))
            CodeLine("    focus = ", "listOf(", "\"Compose\", \"Clean-Arch\"", ")", color1 = Color(0xFFD19A66), color2 = Color(0xFF61AFEF))
            CodeLine(")", "", "", "")
            Spacer(modifier = Modifier.height(8.sdp))
            CodeLine("fun", " buildPlatform", "() {", "", color1 = Color(0xFFC678DD), color2 = Color(0xFF61AFEF))
            CodeLine("    expect", " val ", "uiFramework: UI", "", color1 = Color(0xFFC678DD), color2 = Color(0xFFD19A66))
            CodeLine("    actual", " val ", "uiFramework = JetpackCompose", "", color1 = Color(0xFFC678DD), color2 = Color(0xFFD19A66))
            CodeLine("}", "", "", "")
        }
    }
}

@Composable
fun Dot(color: Color) {
    Box(
        modifier = Modifier
            .size(6.sdp)
            .background(color, RoundedCornerShape(50))
    )
}

@Composable
fun CodeLine(part1: String, part2: String, part3: String, part4: String, color1: Color = TextDark, color2: Color = TextDark) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = color1)) { append(part1) }
            withStyle(style = SpanStyle(color = color2)) { append(part2) }
            append(part3)
            withStyle(style = SpanStyle(color = Color(0xFF98C379))) { append(part4) }
        },
        fontSize = 6.ssp,
        fontFamily = FontFamily.Monospace
    )
}

@Composable
fun MyCard(
    modifier: Modifier = Modifier,
    isMobile: Boolean,
    headingText: String,
    description: String,
    icon: org.jetbrains.compose.resources.DrawableResource
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = CardBg),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.sdp),
        shape = RoundedCornerShape(8.sdp),
        border = BorderStroke(0.5.sdp, lightGray)
    ) {
        Column(
            modifier = Modifier.padding(12.sdp),
            verticalArrangement = Arrangement.spacedBy(4.sdp)
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(16.sdp),
                colorFilter = ColorFilter.tint(PrimaryPurple)
            )
            Text(
                text = headingText,
                fontSize = if (isMobile) 7.ssp else 5.ssp,
                color = TextLight,
                fontFamily = FontFamily(Font(Res.font.Montserrat_Medium))
            )
            Text(
                text = description,
                fontSize = if (isMobile) 10.ssp else 8.ssp,
                color = TextDark,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(Res.font.Montserrat_Bold))
            )
        }
    }
}

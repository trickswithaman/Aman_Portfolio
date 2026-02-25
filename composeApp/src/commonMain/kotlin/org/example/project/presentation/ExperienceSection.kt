package org.example.project.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import myportfolio.composeapp.generated.resources.*
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.*
import org.jetbrains.compose.resources.Font

@Composable
fun ExperienceSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.sdp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Experience",
                    fontSize = 14.ssp,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
                    color = TextDark
                )
                Text(
                    text = "My professional journey in software engineering.",
                    fontSize = 7.ssp,
                    color = TextLight,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Medium)),
                    modifier = Modifier.padding(top = 8.sdp)
                )
            }

            Column(
                modifier = Modifier.weight(2f),
                verticalArrangement = Arrangement.spacedBy(20.sdp)
            ) {
                ExperienceItem(
                    company = "3dverse Technologies",
                    role = "Kotlin Multiplatform Engineer",
                    period = "Jan 2023 - Present",
                    points = listOf(
                        "Engineered scalable KMP modules for networking and local data storage, reducing iOS development time by 30%.",
                        "Led the transition from XML to Jetpack Compose, improving UI performance and developer velocity.",
                        "Implemented modular Clean Architecture to separate concerns and improve unit test coverage to 85%."
                    )
                )
            }
        }
    }
}

@Composable
fun ExperienceItem(company: String, role: String, period: String, points: List<String>) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(8.sdp)
                    .background(PrimaryPurple, RoundedCornerShape(50))
            )
            Box(
                modifier = Modifier
                    .width(1.sdp)
                    .height(100.sdp) // Adjust height dynamically if possible, or use a simpler approach
                    .background(lightGray)
            )
        }
        
        Spacer(modifier = Modifier.width(12.sdp))
        
        Column(verticalArrangement = Arrangement.spacedBy(4.sdp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = company,
                    fontSize = 10.ssp,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
                    color = TextDark
                )
                Text(
                    text = period,
                    fontSize = 6.ssp,
                    color = TextLight,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Medium))
                )
            }
            
            Text(
                text = role,
                fontSize = 7.ssp,
                color = PrimaryPurple,
                fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold))
            )
            
            Spacer(modifier = Modifier.height(8.sdp))
            
            points.forEach { point ->
                Row(modifier = Modifier.padding(bottom = 6.sdp)) {
                    Text(
                        text = "•",
                        fontSize = 7.ssp,
                        color = TextLight,
                        modifier = Modifier.padding(end = 6.sdp)
                    )
                    Text(
                        text = point,
                        fontSize = 7.ssp,
                        lineHeight = 10.ssp,
                        color = TextLight,
                        fontFamily = FontFamily(Font(Res.font.Montserrat_Regular))
                    )
                }
            }
        }
    }
}

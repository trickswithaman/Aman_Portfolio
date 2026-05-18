package org.example.project.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import myportfolio.composeapp.generated.resources.*
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.*
import org.jetbrains.compose.resources.Font

@Composable
fun ExperienceSection(isMobile: Boolean, experiences: List<ExperienceData>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.sdp)
    ) {
        if (isMobile) {
            Column(modifier = Modifier.fillMaxWidth()) {
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
                    modifier = Modifier.padding(top = 8.sdp, bottom = 20.sdp)
                )

                experiences.forEachIndexed { index, experience ->
                    ExperienceItem(
                        company = experience.company,
                        role = experience.role,
                        period = experience.period,
                        points = experience.points,
                        isLast = index == experiences.size - 1
                    )
                }
            }
        } else {
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier.weight(1f)) {
                    Column {
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
                }

                Column(
                    modifier = Modifier.weight(2f),
                    verticalArrangement = Arrangement.spacedBy(20.sdp)
                ) {
                    experiences.forEachIndexed { index, experience ->
                        ExperienceItem(
                            company = experience.company,
                            role = experience.role,
                            period = experience.period,
                            points = experience.points,
                            isLast = index == experiences.size - 1
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ExperienceItem(
    company: String,
    role: String,
    period: String,
    points: List<String>,
    isLast: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight()
        ) {
            Box(
                modifier = Modifier
                    .size(8.sdp)
                    .background(PrimaryPurple, RoundedCornerShape(50))
            )
            if (!isLast) {
                Box(
                    modifier = Modifier
                        .width(1.sdp)
                        .weight(1f)
                        .background(lightGray)
                )
            }
        }

        Spacer(modifier = Modifier.width(12.sdp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.sdp),
            verticalArrangement = Arrangement.spacedBy(4.sdp)
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

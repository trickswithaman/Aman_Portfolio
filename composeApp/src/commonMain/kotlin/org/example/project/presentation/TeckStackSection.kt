package org.example.project.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import myportfolio.composeapp.generated.resources.Montserrat_Bold
import myportfolio.composeapp.generated.resources.Montserrat_SemiBold
import myportfolio.composeapp.generated.resources.Res
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.CardBg
import org.example.project.PrimaryPurple
import org.example.project.TextDark
import org.example.project.components.CustomText
import org.jetbrains.compose.resources.Font

@Composable
fun TechStackSection(isMobile: Boolean, skillList: List<String>) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Technical Stack",
            fontSize = 14.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
            color = TextDark,
            modifier = Modifier.padding(bottom = 10.sdp)
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(7.sdp),
            verticalArrangement = Arrangement.spacedBy(7.sdp)
        ) {
            StackCategory(
                skills = skillList,
                modifier = Modifier.weight(1f),
                fontSize = if (isMobile) 8.ssp else 6.ssp
            )
        }
    }
}

@Composable
fun StackCategory(skills: List<String>, modifier: Modifier = Modifier, fontSize: TextUnit = 6.ssp) {
    Column(
        modifier = modifier.background(CardBg, RoundedCornerShape(8.sdp)),
        verticalArrangement = Arrangement.spacedBy(8.sdp)
    ) {

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(4.sdp),
            verticalArrangement = Arrangement.spacedBy(4.sdp)
        ) {
            skills.forEach { skill ->
                CustomText(
                    text = skill,
                    fontSize = fontSize,
                    color = PrimaryPurple,
                    modifier = Modifier.background(
                            PrimaryPurple.copy(0.1f),
                            RoundedCornerShape(4.sdp)
                        ).padding(horizontal = 6.sdp, vertical = 2.sdp),
                    fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold))
                )
            }
        }
    }
}

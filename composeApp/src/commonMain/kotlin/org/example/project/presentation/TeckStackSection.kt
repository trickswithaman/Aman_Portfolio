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
fun TechStackSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.sdp)
    ) {
        Text(
            text = "Technical Stack",
            fontSize = 14.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
            color = TextDark,
            modifier = Modifier.padding(bottom = 20.sdp)
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.sdp),
            verticalArrangement = Arrangement.spacedBy(15.sdp)
        ) {
            StackCategory(
                title = "Mobile",
                skills = listOf("Kotlin", "Compose", "SwiftUI", "Android SDK"),
                modifier = Modifier.weight(1f)
            )
            StackCategory(
                title = "Architecture",
                skills = listOf("MVVM", "MVI", "Clean Arch", "Solid"),
                modifier = Modifier.weight(1f)
            )
            StackCategory(
                title = "Backend",
                skills = listOf("Firebase", "Ktor", "Supabase"),
                modifier = Modifier.weight(1f)
            )
            StackCategory(
                title = "Tools",
                skills = listOf("Git", "CI/CD", "Figma", "Jira"),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun StackCategory(title: String, skills: List<String>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(CardBg, RoundedCornerShape(8.sdp))
            .padding(12.sdp),
        verticalArrangement = Arrangement.spacedBy(8.sdp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(12.sdp).background(PrimaryPurple.copy(0.1f), RoundedCornerShape(4.sdp)))
            Spacer(modifier = Modifier.width(6.sdp))
            Text(
                text = title,
                fontSize = 7.ssp,
                fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold)),
                color = TextDark
            )
        }
        
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(4.sdp),
            verticalArrangement = Arrangement.spacedBy(4.sdp)
        ) {
            skills.forEach { skill ->
                Text(
                    text = skill,
                    fontSize = 5.ssp,
                    color = PrimaryPurple,
                    modifier = Modifier
                        .background(PrimaryPurple.copy(0.05f), RoundedCornerShape(4.sdp))
                        .padding(horizontal = 6.sdp, vertical = 2.sdp),
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Medium))
                )
            }
        }
    }
}

package org.example.project.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import myportfolio.composeapp.generated.resources.*
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.*
import org.example.project.components.CustomText
import org.jetbrains.compose.resources.Font

@Composable
fun AboutMe(
    isMobile: Boolean ,
    leftText : String,
    rightText : AnnotatedString,

) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.sdp)
    ) {
        if (isMobile){
            Column(verticalArrangement = Arrangement.spacedBy(16.sdp)) {
                AboutMeLeftSection(leftText = leftText, isMobile = isMobile)
                AboutMeRightSection(rightText = rightText,isMobile = isMobile)
            }

        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.sdp)
            ) {
                AboutMeLeftSection(leftText = leftText, modifier = Modifier.weight(1f),isMobile = isMobile)
                // Right column: Description and Template Card
                AboutMeRightSection(modifier = Modifier.weight(2f), rightText = rightText,isMobile = isMobile)
            }
        }

    }
}

@Composable
fun AboutMeLeftSection (
    isMobile: Boolean,
    modifier: Modifier = Modifier,
    leftText : String,
){
    // Left column: "About Me" heading
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(5.sdp)) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(3.sdp)) {
            Box(
                modifier = Modifier
                    .width(3.sdp)
                    .height(20.sdp)
                    .background(PrimaryPurple)
            )
            CustomText(
                text = "About Me",
                modifier = Modifier.padding(start = 3.sdp),
                fontSize = if (isMobile)18.ssp else 14.ssp,
                fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
                color = TextDark
            )
        }
        CustomText(
            text = leftText,
            fontSize =if (isMobile) 10.ssp else 7.ssp,
            color = Color.Gray,
        )
    }
}
@Composable
fun AboutMeRightSection (
    isMobile: Boolean ,
    modifier: Modifier = Modifier,
    rightText: AnnotatedString
){
    Column(modifier = modifier) {
        Text(
            text = rightText,
            fontSize =if (!isMobile) 8.ssp else 7.ssp,
            lineHeight = 12.ssp,
            color = Color.Gray,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Regular))
        )
    }
}

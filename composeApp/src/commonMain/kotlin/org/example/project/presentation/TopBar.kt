package org.example.project.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontFamily
import myportfolio.composeapp.generated.resources.*
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun TopBar(isMobile: Boolean, isSelected: MutableState<String>) {
    Surface(
        modifier = Modifier.fillMaxWidth().height(if (isMobile) 50.sdp else 40.sdp),
        color = White,
        shadowElevation = 1.sdp
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val screenWidth = maxWidth
            val horizontalPadding = if (isMobile) 15.sdp else screenWidth * 0.15f
            
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = horizontalPadding),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(if (isMobile) 16.sdp else 12.sdp)
                            .background(PrimaryPurple, RoundedCornerShape(50)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "A",
                            color = White,
                            fontSize = if (isMobile) 8.ssp else 6.ssp,
                            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold))
                        )
                    }
                    Spacer(modifier = Modifier.width(6.sdp))
                    Text(
                        text = "Aman Saxena",
                        fontSize = if (isMobile) 10.ssp else 8.ssp,
                        fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
                        color = TextDark
                    )
                }

                if (!isMobile) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(15.sdp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val menuItems = listOf("About", "Projects", "Experience", "Skills")
                        menuItems.forEach { item ->
                            TextButton(onClick = { isSelected.value = item }) {
                                Text(
                                    text = item,
                                    fontSize = 6.ssp,
                                    color = if (isSelected.value == item) PrimaryPurple else TextLight,
                                    fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold))
                                )
                            }
                        }
                    }
                }

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryPurple),
                    shape = RoundedCornerShape(20.sdp),
                    contentPadding = PaddingValues(horizontal = 16.sdp, vertical = 6.sdp)
                ) {
                    Text(
                        text = "Contact me",
                        fontSize = if (isMobile) 8.ssp else 6.ssp,
                        fontFamily = FontFamily(Font(Res.font.Montserrat_Bold))
                    )
                }
            }
        }
    }
}

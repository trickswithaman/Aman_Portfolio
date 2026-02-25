package org.example.project.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import myportfolio.composeapp.generated.resources.*
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun ContactSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 40.sdp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = PrimaryPurple),
            shape = RoundedCornerShape(16.sdp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 40.sdp, horizontal = 20.sdp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.sdp)
            ) {
                Text(
                    text = "Let's Build Scalable Digital Products",
                    fontSize = 18.ssp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
                    textAlign = TextAlign.Center,
                    lineHeight = 22.ssp
                )

                Text(
                    text = "Currently open to freelance opportunities and full-time roles focused on Kotlin Multiplatform.",
                    fontSize = 7.ssp,
                    color = Color.White.copy(alpha = 0.8f),
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Medium)),
                    textAlign = TextAlign.Center
                )

                Row(
                    modifier = Modifier.padding(top = 10.sdp),
                    horizontalArrangement = Arrangement.spacedBy(10.sdp)
                ) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        shape = RoundedCornerShape(8.sdp),
                        contentPadding = PaddingValues(horizontal = 20.sdp, vertical = 10.sdp)
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_download), // Replace with email icon
                            contentDescription = null,
                            tint = PrimaryPurple,
                            modifier = Modifier.size(12.sdp)
                        )
                        Spacer(modifier = Modifier.width(6.sdp))
                        Text(
                            text = "Email Me",
                            fontSize = 7.ssp,
                            color = PrimaryPurple,
                            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold))
                        )
                    }

                    OutlinedButton(
                        onClick = {},
                        shape = RoundedCornerShape(8.sdp),
                        border = androidx.compose.foundation.BorderStroke(1.sdp, Color.White),
                        contentPadding = PaddingValues(horizontal = 20.sdp, vertical = 10.sdp)
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_download), // Replace with linkedin icon
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(12.sdp)
                        )
                        Spacer(modifier = Modifier.width(6.sdp))
                        Text(
                            text = "LinkedIn",
                            fontSize = 7.ssp,
                            color = Color.White,
                            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold))
                        )
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(40.sdp))
        Footer()
    }
}

@Composable
fun Footer() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Divider(color = lightGray, thickness = 0.5.sdp)
        Spacer(modifier = Modifier.height(20.sdp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(12.sdp)
                        .background(PrimaryPurple, RoundedCornerShape(50))
                )
                Spacer(modifier = Modifier.width(6.sdp))
                Text(
                    text = "Aman Saxena",
                    fontSize = 7.ssp,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold)),
                    color = TextDark
                )
            }
            
            Text(
                text = "© 2024 Portfolio. Designed for the Future of Mobile.",
                fontSize = 6.ssp,
                color = TextLight,
                fontFamily = FontFamily(Font(Res.font.Montserrat_Regular))
            )

            Row(horizontalArrangement = Arrangement.spacedBy(10.sdp)) {
                // Icons for GitHub, LinkedIn, etc.
                Icon(painterResource(Res.drawable.ic_download), null, modifier = Modifier.size(12.sdp), tint = TextLight)
                Icon(painterResource(Res.drawable.ic_download), null, modifier = Modifier.size(12.sdp), tint = TextLight)
                Icon(painterResource(Res.drawable.ic_download), null, modifier = Modifier.size(12.sdp), tint = TextLight)
            }
        }
        Spacer(modifier = Modifier.height(20.sdp))
    }
}

package org.example.project.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

@Composable
fun AboutMe() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.sdp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.sdp)
        ) {
            // Left column: "About Me" heading
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .width(3.sdp)
                            .height(20.sdp)
                            .background(PrimaryPurple)
                    )
                    Spacer(modifier = Modifier.width(8.sdp))
                    Text(
                        text = "About Me",
                        fontSize = 14.ssp,
                        fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
                        color = TextDark
                    )
                }
                Text(
                    text = "Bridging the gap between platforms with shared logic and native performance.",
                    fontSize = 7.ssp,
                    color = TextLight,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Medium)),
                    modifier = Modifier.padding(top = 8.sdp)
                )
            }

            // Right column: Description and Template Card
            Column(modifier = Modifier.weight(2f)) {
                Text(
                    text = buildAnnotatedString {
                        append("I am a software engineer focused on the ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = TextDark)) {
                            append("**Kotlin ecosystem**")
                        }
                        append(". My passion lies in building scalable, maintainable mobile applications using **Kotlin Multiplatform (KMP)**. By leveraging MVVM/MVI architectures and Firebase, I deliver products that run seamlessly on both Android and iOS while maintaining a single source of truth for business logic.")
                    },
                    fontSize = 8.ssp,
                    lineHeight = 12.ssp,
                    color = TextLight,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Regular))
                )

                Spacer(modifier = Modifier.height(16.sdp))

                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
                    shape = RoundedCornerShape(6.sdp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(12.sdp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(14.sdp)
                                .background(Color.White.copy(alpha = 0.1f), RoundedCornerShape(4.sdp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("🚀", fontSize = 8.ssp)
                        }
                        Spacer(modifier = Modifier.width(10.sdp))
                        Column {
                            Text(
                                text = "Featured on KMP.libs",
                                fontSize = 5.ssp,
                                color = Color.Gray
                            )
                            Text(
                                text = "Enterprise-grade KMP Template with Clean Architecture",
                                fontSize = 7.ssp,
                                color = Color.White,
                                fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold))
                            )
                        }
                    }
                }
            }
        }
    }
}

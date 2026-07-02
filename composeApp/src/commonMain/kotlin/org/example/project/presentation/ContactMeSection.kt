package org.example.project.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.platform.LocalUriHandler
import myportfolio.composeapp.generated.resources.*
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun ContactSection(
    isMobile: Boolean,
    email: String = PortfolioConstants.MAIL_TO,
    whatsapp: String = PortfolioConstants.WHATSAPP_URL,
    linkedin: String = PortfolioConstants.LINKEDIN_URL,
    github: String = PortfolioConstants.GITHUB_URL,
    name: String = PortfolioConstants.NAME
) {
    val uriHandler = LocalUriHandler.current

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
                    fontSize = if (isMobile) 14.ssp else 18.ssp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
                    textAlign = TextAlign.Center,
                    lineHeight = if (isMobile) 18.ssp else 22.ssp
                )

                Text(
                    text = "Currently open to freelance opportunities and full-time roles focused on Kotlin Multiplatform.",
                    fontSize = if (isMobile) 8.ssp else 7.ssp,
                    color = Color.White.copy(alpha = 0.8f),
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Medium)),
                    textAlign = TextAlign.Center
                )

                FlowRow(
                    modifier = Modifier.padding(top = 10.sdp),
                    horizontalArrangement = Arrangement.Center,
                    verticalArrangement = Arrangement.spacedBy(10.sdp)
                ) {
                    Button(
                        onClick = { uriHandler.openUri(email) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        shape = RoundedCornerShape(8.sdp),
                        contentPadding = PaddingValues(horizontal = 16.sdp, vertical = 8.sdp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null,
                            tint = PrimaryPurple,
                            modifier = Modifier.size(12.sdp)
                        )
                        Spacer(modifier = Modifier.width(6.sdp))
                        Text(
                            text = "Email Me",
                            fontSize = if (isMobile) 8.ssp else 7.ssp,
                            color = PrimaryPurple,
                            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold))
                        )
                    }
                    Spacer(modifier = Modifier.width(6.sdp))
                    OutlinedButton(
                        onClick = { uriHandler.openUri(whatsapp) },
                        shape = RoundedCornerShape(8.sdp),
                        border = androidx.compose.foundation.BorderStroke(1.sdp, Color.White),
                        contentPadding = PaddingValues(horizontal = 16.sdp, vertical = 8.sdp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Whatsapp,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(12.sdp)
                        )
                        Spacer(modifier = Modifier.width(6.sdp))
                        Text(
                            text = "WhatsApp",
                            fontSize = if (isMobile) 8.ssp else 7.ssp,
                            color = Color.White,
                            fontFamily = FontFamily(Font(Res.font.Montserrat_Bold))
                        )
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(40.sdp))
        Footer(isMobile, name, github, linkedin, whatsapp, email)
    }
}

@Composable
fun Footer(
    isMobile: Boolean,
    name: String = PortfolioConstants.NAME,
    github: String = PortfolioConstants.GITHUB_URL,
    linkedin: String = PortfolioConstants.LINKEDIN_URL,
    whatsapp: String = PortfolioConstants.WHATSAPP_URL,
    email: String = PortfolioConstants.MAIL_TO
) {
    val uriHandler = LocalUriHandler.current

    Column(modifier = Modifier.fillMaxWidth())
    {
        Divider(color = lightGray, thickness = 0.5.sdp)
        Spacer(modifier = Modifier.height(10.sdp))
        
        if (isMobile) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.sdp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(12.sdp)
                            .background(PrimaryPurple, RoundedCornerShape(50))
                    )
                    Spacer(modifier = Modifier.width(6.sdp))
                    Text(
                        text = name,
                        fontSize = 9.ssp,
                        fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold)),
                        color = TextDark
                    )
                }

                Row(horizontalArrangement = Arrangement.spacedBy(20.sdp)) {
                    IconButton(onClick = { uriHandler.openUri(github) }, modifier = Modifier.size(24.sdp)) {
                        Icon(painterResource(Res.drawable.ic_github), null, tint = TextLight, modifier = Modifier.size(20.sdp))
                    }
                    IconButton(onClick = { uriHandler.openUri(linkedin) }, modifier = Modifier.size(24.sdp)) {
                        Icon(painterResource(Res.drawable.ic_linkdin), null, tint = TextLight, modifier = Modifier.size(20.sdp))
                    }
                    IconButton(onClick = { uriHandler.openUri(whatsapp) }, modifier = Modifier.size(24.sdp)) {
                        Icon(imageVector = Icons.Default.Whatsapp, null, tint = TextLight, modifier = Modifier.size(20.sdp))
                    }
                    IconButton(onClick = { uriHandler.openUri(email) }, modifier = Modifier.size(24.sdp)) {
                        Icon(imageVector = Icons.Default.Email, null, tint = TextLight, modifier = Modifier.size(20.sdp))
                    }
                }

                Text(
                    text = PortfolioConstants.COPYRIGHT_TEXT,
                    fontSize = 7.ssp,
                    color = TextLight,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Regular)),
                    textAlign = TextAlign.Center
                )
            }
        } else {
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
                        text = name,
                        fontSize = 7.ssp,
                        fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold)),
                        color = TextDark
                    )
                }
                
                Text(
                    text = PortfolioConstants.COPYRIGHT_TEXT,
                    fontSize = 6.ssp,
                    color = TextLight,
                    fontFamily = FontFamily(Font(Res.font.Montserrat_Regular))
                )

                Row(horizontalArrangement = Arrangement.spacedBy(5.sdp)) {
                    IconButton(onClick = { uriHandler.openUri(github) }, modifier = Modifier.size(12.sdp)) {
                        Icon(painterResource(Res.drawable.ic_github), null, tint = TextLight)
                    }
                    IconButton(onClick = { uriHandler.openUri(linkedin) }, modifier = Modifier.size(12.sdp)) {
                        Icon(painterResource(Res.drawable.ic_linkdin), null, tint = TextLight)
                    }
                    IconButton(onClick = { uriHandler.openUri(whatsapp) }, modifier = Modifier.size(12.sdp)) {
                        Icon(imageVector = Icons.Default.Whatsapp, null, tint = TextLight)
                    }
                    IconButton(onClick = { uriHandler.openUri(email) }, modifier = Modifier.size(12.sdp)) {
                        Icon(imageVector = Icons.Default.Email, null, tint = TextLight)
                    }
                }
            }
        }

    }
}

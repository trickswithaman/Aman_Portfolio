package org.example.project.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontFamily
import myportfolio.composeapp.generated.resources.*
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.*
import org.example.project.components.CustomButton
import org.example.project.components.CustomText
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource


@Composable
fun TopBar(isMobile: Boolean, selectedItem: PortfolioSection, onNavigate: (PortfolioSection) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth().height(if (isMobile) 50.sdp else 30.sdp),
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
                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable { onNavigate(PortfolioSection.Home) },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(if (isMobile) 16.sdp else 12.sdp)
                            .background(PrimaryPurple, RoundedCornerShape(50)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.ic_topbar),
                            contentDescription = null,
                            modifier = Modifier.size(6.sdp),
                            colorFilter = ColorFilter.tint(White),
                        )
                    }
                    Spacer(modifier = Modifier.width(6.sdp))
                    Text(
                        text = PortfolioConstants.NAME,
                        fontSize = if (isMobile) 10.ssp else 8.ssp,
                        fontFamily = FontFamily(Font(Res.font.Montserrat_Bold)),
                        color = TextDark
                    )
                }

                if (!isMobile) {
                    Row(
                        modifier = Modifier.weight(1f).padding(horizontal = 5.sdp),
                        horizontalArrangement = Arrangement.spacedBy(3.sdp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Spacer(Modifier.weight(1f))
                        val menuItems = listOf(
                            PortfolioSection.About,
                            PortfolioSection.Skills,
                            PortfolioSection.Projects,
                            PortfolioSection.Experience
                        )
                        menuItems.forEach { item ->
                            TextButton(
                                onClick = { onNavigate(item)  }) {
                                CustomText(
                                    text = item.title,
                                    fontSize = 6.ssp,
                                    color = if (selectedItem == item) PrimaryPurple else TextLight,
                                )
                            }
                        }
                    }
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }
                CustomButton(
                    text = "Contact Me",
                    onClick = { onNavigate(PortfolioSection.Contact)}
                )
            }
        }
    }
}

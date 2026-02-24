package org.example.project.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontFamily
import myportfolio.composeapp.generated.resources.Montserrat_Bold
import myportfolio.composeapp.generated.resources.Montserrat_SemiBold
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.container
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.isSelectedColor
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource


@Composable
fun TopBar (isMobile : Boolean,isSelected : MutableState<String>){
    Row (
        modifier = Modifier.fillMaxWidth().fillMaxHeight(if (!isMobile)0.075f else 0.08f).background(color = White)
    ){
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
        ) {

            val screenWidth = maxWidth
            val paddingPercent = 0.20f // 15%
            val horizontalPadding = screenWidth * paddingPercent
            Box(
                modifier = Modifier.padding(horizontal = if (!isMobile)horizontalPadding else 10.sdp).background(color = White).fillMaxSize(),

                ) {
                Row (
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ){
                    Image(
                        painterResource(Res.drawable.container),
                        contentDescription = null,
                        modifier = Modifier
                            .size(if (!isMobile )12.sdp else 14.sdp)
                    )

                    Text(
                        text = "Aman Saxena",
                        fontSize =if (!isMobile) 8.5.ssp else 10.ssp,
                        fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold )),
                        modifier = Modifier.padding(horizontal = 5.sdp).align(alignment = Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.weight(1f))


                    if (!isMobile){
                        val menuItems = listOf("Home", "About", "Skills", "Projects")

                        menuItems.forEach { item ->
                            MenuButton(
                                title = item,
                                isSelected = isSelected.value == item
                            ) {
                                isSelected.value = item
                            }
                        }
                    }

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = isSelectedColor),
                        shape = RoundedCornerShape(2.5.sdp),
                        modifier = Modifier.wrapContentSize().padding(vertical = 3.sdp),
                    ){
                        Text(
                            text = "Contact me",
                            fontSize =if (!isMobile) 6.ssp else 8.ssp,
                            fontFamily = FontFamily(  Font(Res.font.Montserrat_Bold))
                        )
                    }

                }



            }
        }
    }
}

@Composable
fun MenuButton(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.sdp),
        colors = ButtonDefaults.buttonColors(
            containerColor =
                Color.Transparent
        ),
        modifier = Modifier.wrapContentWidth().height(15.sdp)
            .padding(horizontal = 2.sdp, vertical = 1.sdp)
    ) {
        Text(
            text = title,
            fontSize = 5.5.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold )),
            color = if (isSelected) isSelectedColor else Black
        )
    }
}

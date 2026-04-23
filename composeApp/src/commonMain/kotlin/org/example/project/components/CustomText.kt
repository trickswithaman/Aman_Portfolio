package org.example.project.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import myportfolio.composeapp.generated.resources.Montserrat_Medium
import myportfolio.composeapp.generated.resources.Montserrat_SemiBold
import myportfolio.composeapp.generated.resources.Res
import network.chaintech.sdpcomposemultiplatform.ssp

@Composable
fun ButtonText(
    text: String,
    modifier: Modifier = Modifier,
    fontFamily: FontFamily =FontFamily(org.jetbrains.compose.resources.Font(Res.font.Montserrat_SemiBold)),
    fontSize: TextUnit = 6.ssp,
    color: Color = Color.Black
){
    Text(
        text = text,
        modifier = modifier,
        fontFamily = fontFamily,
        fontSize = fontSize,
        color = color
    )
}

@Composable
fun CustomText (
    text: String,
    fontSize: TextUnit= 10.ssp,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    fontFamily: FontFamily = FontFamily(org.jetbrains.compose.resources.Font(Res.font.Montserrat_Medium))
){
    Text(
        text = text,
        fontSize = fontSize,
        modifier = modifier,
        color = color,
        fontFamily = fontFamily
    )
}
package org.example.project.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.TextUnit
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.PrimaryPurple


@Composable
fun CustomButton(
    textSize: TextUnit = 6.ssp,
    text: String,
    buttonColor: Color = PrimaryPurple,
    textColor: Color = Color.White,
    onClick: () -> Unit,
    shape: Shape = RoundedCornerShape(10.sdp),
    modifier: Modifier = Modifier,
    ){
    Button(
        onClick = onClick,
        modifier = modifier.shadow(
            clip = false,
            spotColor = PrimaryPurple,
            shape = shape,
            elevation = 3.sdp
        ),
        shape =shape ,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,

        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 5.sdp,
        )
    ){
        ButtonText(
            color = textColor,
            text = text,

            fontSize =textSize,
            modifier = Modifier.padding(vertical = 2.sdp)
        )
    }


}



package org.example.project.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import network.chaintech.sdpcomposemultiplatform.sdp


@Composable
fun AboutMe (){
    Card (
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.sdp
        ),
        shape = RoundedCornerShape(3.sdp)
    ){
        FlowRow(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(1f).background(White),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.Center
        ){
            Text("About Me Sectiopn")
        }
    }

}

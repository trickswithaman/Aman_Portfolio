package org.example.project.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.example.project.lightGray


@Composable
fun TechStackSection (){
    FlowRow(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(1f).background(lightGray),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.Center
    ){
        Text("TechStack Sectiopn")
    }
}

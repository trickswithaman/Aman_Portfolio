package org.example.project.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import myportfolio.composeapp.generated.resources.Montserrat_Black
import myportfolio.composeapp.generated.resources.Montserrat_Bold
import myportfolio.composeapp.generated.resources.Montserrat_Medium
import myportfolio.composeapp.generated.resources.Montserrat_Regular
import myportfolio.composeapp.generated.resources.Montserrat_SemiBold
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.ic_coding
import myportfolio.composeapp.generated.resources.ic_download
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.example.project.isSelectedColor
import org.example.project.lightGray
import org.example.project.lightGray2
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Preview(showBackground = true)
@Composable
fun TopSection (isMobile : Boolean){
    Column (
        modifier = Modifier.wrapContentSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        FlowRow(
            modifier = Modifier.fillMaxWidth().background(Color.White.copy(alpha = 0.3f)),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.Center
        ){
            Box(
                modifier = Modifier.weight(1f)
            ){
                LeftBox(isMobile)

            }
            if (!isMobile){
                Spacer(Modifier.weight(0.2f))
                Box(
                    modifier = Modifier.weight(1f)
                ){
                    RightBox()

                }

            } else {}

        }

        FlowRow(
            modifier = Modifier.wrapContentSize(),
            horizontalArrangement = Arrangement.spacedBy(10.sdp),
            verticalArrangement = Arrangement.spacedBy(10.sdp),
            maxLines = 2,


        ){
            MyCard(
                isMobile = isMobile,
                headingText = "Experience",
                description = "1.5+ years"
            )
            MyCard(
                isMobile = isMobile,
                headingText = "Projects",
                description = "3+ Done "
            )
            MyCard(
                isMobile = isMobile,
                headingText = "Tech Stack",
                description = "1.5+ years"
            )
            MyCard(
                isMobile = isMobile,
                headingText = "Experience",
                description = "1.5+ years"
            )
        }


    }


}
@Preview
@Composable
fun MyCard(
    isMobile : Boolean = false,
    modifier: Modifier = Modifier,
    headingText : String,
    description : String
){
    Card (
        modifier = modifier
            .wrapContentSize()
            .border(
                width = 0.5.sdp,
                color = lightGray,
                shape = RoundedCornerShape(5.sdp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.sdp
        )


    ){
        Column (
            modifier = Modifier.wrapContentSize().padding(vertical =if (!isMobile) 15.sdp else 18.sdp, horizontal =if (!isMobile) 18.sdp else
            22.sdp)
        ){
            Text(
                text = headingText,
                fontSize = if (!isMobile) 6.ssp else 8.ssp,
                color = Color.Gray.copy(0.8f),
                fontFamily = FontFamily(Font(Res.font.Montserrat_Medium))
            )

            Text(
                text = description,
                fontSize = if (!isMobile) 10.ssp else 12.ssp,
                color = isSelectedColor,
                fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold))
            )

        }
    }
}

@Composable
fun LeftBox(isMobile: Boolean){
    Column (
        modifier = Modifier.wrapContentSize().padding(vertical = 25.sdp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(3.sdp)
    )
    {
        Text(
            text = "AVAILABLE FOR HIRE",
            fontSize = if (!isMobile) 5.ssp else
                8.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_SemiBold)),
            color = isSelectedColor,
            modifier = Modifier
                .background(
                    color = isSelectedColor.copy(0.1f),
                    shape = RoundedCornerShape(8.sdp)
                ).padding(vertical = 3.sdp, horizontal = 4.sdp)

        )

        Text(
            text = "Android & KMP Developer.",
            fontSize =  if (!isMobile) 16.ssp else 25.ssp,
            lineHeight = if (!isMobile)15.ssp else 20.ssp,
            fontFamily = FontFamily(Font(Res.font.Montserrat_Black)),
            color = Color.Black,
        )

        Text(
            text = "Crafting high - performance, cross platform mobile experience with kotlin Multiplatform (KMP) and jetpack compose",
            fontSize =if (!isMobile) 6.ssp else 10.ssp,
            lineHeight =if (!isMobile) 10.ssp else 15.ssp,

            fontFamily = FontFamily(Font(Res.font.Montserrat_Medium)),
            color = lightGray2.copy(alpha = 0.7f),
        )

        Row (modifier = Modifier.wrapContentSize()){
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = isSelectedColor),
                shape = RoundedCornerShape(2.5.sdp),
                modifier = Modifier.wrapContentSize().padding( end = 3.sdp, top = 3.sdp, bottom = 3.sdp),
            ){
                Text(
                    text = "View Projects",
                    fontSize = if (isMobile)9.ssp else 6.ssp,
                    fontFamily = FontFamily(  Font(Res.font.Montserrat_Bold))
                )
                Image(painter = painterResource(Res.drawable.ic_download),
                    contentDescription = null, modifier = Modifier.size(if (isMobile) 8.sdp else 10.sdp).padding(start = 3.sdp), colorFilter = ColorFilter.tint(color = Color.White))

            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = ButtonDefaults.outlinedButtonBorder(
                   enabled = true
                ),
                shape = RoundedCornerShape(2.5.sdp),
                modifier = Modifier.wrapContentSize().padding( 3.sdp),
            ){
                Text(
                    text = "Download Resume ",
                    fontSize = if (isMobile)9.ssp else 6.ssp,
                    color = isSelectedColor,
                    fontFamily = FontFamily(  Font(Res.font.Montserrat_Bold))
                )
                Image(
                    painter = painterResource(Res.drawable.ic_download),
                    contentDescription = null,
                    modifier = Modifier.size(if (isMobile) 8.sdp else 10.sdp).padding(start = 3.sdp)
                )
            }
        }
    }
}


@Preview
@Composable
fun RightBox(modifier: Modifier = Modifier){
    Image(
        painter = painterResource(Res.drawable.ic_coding),
        contentDescription = null,
        modifier = modifier.fillMaxSize()
    )
}


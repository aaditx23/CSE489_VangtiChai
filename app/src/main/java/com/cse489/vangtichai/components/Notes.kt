package com.cse489.vangtichai.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val notes = listOf(
    500, 100, 50, 20, 10, 5, 2, 1
)


@Composable
fun BillsPortrait(width: Dp, map: MutableMap<Int, Int>) {


    Box(
        modifier = Modifier
            .layoutId("notesBox")

        ) {
        Column(
            horizontalAlignment = Alignment.End,
        ) {
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            ){
                for (n in notes){
                    Bill(n, width, map)
                }
            }

        }



    }
}

@Composable
fun BillsLandscape(width: Dp, map: MutableMap<Int, Int>){

    Box(
        modifier = Modifier
            .layoutId("notesBox")

    ) {
        Row(

        ){
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Card(
//                    colors = CardDefaults.cardColors(LightIndigo),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                ){
                    for (i in 0..3){
                        Bill(notes[i], width, map)
                    }
                }

            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Card(
//                    colors = CardDefaults.cardColors(LightIndigo),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                ){
                    for (i in 4..7){
                        Bill(notes[i], width, map)
                    }
                }

            }
        }



    }

}

@Composable
fun Bill(n: Int, width: Dp, map: MutableMap<Int, Int>){
    Row(
        modifier = Modifier
            .padding(vertical = 5.dp)
    ) {

            Text(
                text = "$n : ${map[n]}",
                textAlign = TextAlign.End,
                fontSize = 25.sp,
                modifier = Modifier
                    .width(width)
                    .layoutId("bill$n")
            )
    }
}
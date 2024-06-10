package com.cse489.vangtichai.components

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun NumpadPortrait(width: Dp, onNumClick: (Int) -> Unit, onClearClick: ()-> Unit){
    Box(
        modifier = Modifier
            .layoutId("numpadBox")
            .width(width)
    ){
        Column {
            Row(
            ) {

                Button(
                    onClick = { onNumClick(1) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "1")
                }
                Button(
                    onClick = { onNumClick(2) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "2")
                }
                Button(
                    onClick = { onNumClick(3) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "3")
                }
            }

            Row(
            ){
                Button(
                    onClick = { onNumClick(4) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "4")
                }
                Button(
                    onClick = { onNumClick(5) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "5")
                }
                Button(
                    onClick = { onNumClick(6) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "6")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = { onNumClick(7) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "7")
                }
                Button(
                    onClick = { onNumClick(8) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "8")
                }
                Button(
                    onClick = { onNumClick(9) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "9")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = { onNumClick(0) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "0")
                }
                Button(
                    onClick = { onClearClick() },
                    modifier = Modifier.weight(2f)
                ){
                    Text(text = "Clear")
                }
            }
        }
    }
}

@Composable
fun NumpadLandscape(width: Dp, onNumClick: (Int) -> Unit, onClearClick: ()-> Unit){
    Box(
        modifier = Modifier
            .layoutId("numpadBox")
            .width(width)
    ){
        Column {
            Row(
            ) {

                Button(
                    onClick = { onNumClick(1) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "1")
                }
                Button(
                    onClick = { onNumClick(2) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "2")
                }
                Button(
                    onClick = { onNumClick(3) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "3")
                }
                Button(
                    onClick = { onNumClick(4) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "4")
                }
            }

            Row(
            ){

                Button(
                    onClick = { onNumClick(5) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "5")
                }
                Button(
                    onClick = { onNumClick(6) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "6")
                }
                Button(
                    onClick = { onNumClick(7) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "7")
                }
                Button(
                    onClick = { onNumClick(8) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "8")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Button(
                    onClick = { onNumClick(9) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "9")
                }
                Button(
                    onClick = { onNumClick(0) },
                    modifier = Modifier.weight(1f)
                ){
                    Text(text = "0")
                }
                Button(
                    onClick = { onClearClick() },
                    modifier = Modifier.weight(2f)
                ){
                    Text(text = "Clear")
                }
            }
        }
    }

}

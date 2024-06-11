package com.cse489.vangtichai.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cse489.vangtichai.components.BillsPortrait
import com.cse489.vangtichai.components.NumpadPortrait
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.cse489.vangtichai.components.BillsLandscape
import com.cse489.vangtichai.components.NumpadLandscape
import com.cse489.vangtichai.components.notes

@SuppressLint("MutableCollectionMutableState")
@Composable
fun Main(){

    val config = LocalConfiguration.current
    val screenHeight by remember {
        mutableStateOf(config.screenHeightDp.dp)
    }
    val screenWidth by remember {
        mutableStateOf(config.screenWidthDp.dp)
    }

    var typedText by rememberSaveable {
        mutableStateOf("")
    }

    var billMap by rememberSaveable{
        mutableStateOf(
            mutableMapOf(
                500 to 0,
                100 to 0,
                50 to 0,
                20 to 0,
                10 to 0,
                5 to 0,
                2 to 0,
                1 to 0
            )
        )
    }



    BoxWithConstraints {
        val constraint = if(screenWidth < 600.dp){
            portraitConstraint(16, screenHeight, screenWidth)
        }
        else{
            landscapeConstraint(32, screenHeight, screenWidth)
        }

        ConstraintLayout(constraint) {

            Row(
                modifier = Modifier
                    .layoutId("typedText")
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Text(text = "Taka: $typedText")
            }
            if (screenWidth< 600.dp){
                NumpadPortrait(
                    width = screenWidth/2,
                    onNumClick = {n ->
                        typedText += n.toString()
                        calculateBills(typedText, billMap)
                    },
                    onClearClick = {
                        typedText = typedText.dropLast(1)
                        calculateBills(typedText, billMap)
                    }
                    )
                BillsPortrait(width = screenWidth/4, billMap)
            }
            else{
                NumpadLandscape(
                    screenWidth/2,
                    onNumClick = {n ->
                        typedText += n.toString()
                        calculateBills(typedText, billMap)
                    },
                    onClearClick = {
                        typedText = typedText.dropLast(1)
                        calculateBills(typedText, billMap)
                    }
                )
                BillsLandscape(screenWidth/8, billMap)

            }



        }
    }
}


private fun portraitConstraint(margin: Int, scrHeight: Dp, scrWidth: Dp): ConstraintSet {
    return ConstraintSet {
        val numpadRef = createRefFor("numpadBox")
        val billsRef = createRefFor("notesBox")
        val typedRef = createRefFor("typedText")


        // margin values
        val billsMarginTop = (scrHeight/4)
        val billsMarginStart = (scrWidth/20)
        val numpadMarginTop = (scrHeight/8) * 3
        val numpadMarginStart = (scrWidth/7)*3
        val typedMarginTop = (scrHeight/5)


        constrain(billsRef){
            top.linkTo(parent.top, margin = billsMarginTop)
            start.linkTo(parent.start, margin = billsMarginStart)
        }


        constrain(numpadRef){
            top.linkTo(parent.top, margin = numpadMarginTop)
            start.linkTo(parent.start, margin = numpadMarginStart)
        }


        constrain(typedRef){
            top.linkTo(parent.top, margin = typedMarginTop)

        }

    }
}

private fun landscapeConstraint(margin: Int, scrHeight: Dp, scrWidth: Dp): ConstraintSet {
    return ConstraintSet{

        val numpadRef = createRefFor("numpadBox")
        val billsRef = createRefFor("notesBox")
        val typedRef = createRefFor("typedText")


        // margin values
        val billsMarginTop = (scrHeight/8)*3
        val billsMarginStart = (scrWidth/20)
        val numpadMarginTop = (scrHeight/8)*3
        val numpadMarginStart = (scrWidth/2)
        val typedMarginTop = (scrHeight/4)


        constrain(billsRef){
            top.linkTo(parent.top, margin = billsMarginTop)
            start.linkTo(parent.start, margin = billsMarginStart)
        }


        constrain(numpadRef){
            top.linkTo(parent.top, margin = numpadMarginTop)
            start.linkTo(parent.start, margin = numpadMarginStart)
        }


        constrain(typedRef){
            top.linkTo(parent.top, margin = typedMarginTop)

        }

    }
}

private fun calculateBills(text: String, map: MutableMap<Int, Int>){

    var input = 0
    if (text != ""){
        input = text.toInt()
    }
    for (n in notes){
        val count = input / n
        println("Division result is: $count")
        if (count > 0){
            input -= count * n
        }
        map[n] = count
    }
}
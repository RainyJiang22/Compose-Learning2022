package com.rainy.compose_learning.ui.foundation.layout

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @author jiangshiyu
 * @date 2022/8/18
 */

@Preview
@Composable
fun BoxWithConstraintDemo() {

    Column {
        Column {
            MyBoxWithConstraintsDemo()
        }
        Row {
            Text("Hello World")
            Text(text = "Hello World2")
        }
    }

//    Text("Here we set the size to 150.dp", modifier = Modifier.padding(top = 20.dp))
//    Column(modifier = Modifier.size(150.dp)) {
//        MyBoxWithConstraintsDemo()
//    }


}
@Composable
private fun MyBoxWithConstraintsDemo() {
    BoxWithConstraints {
        val boxWithConstraintsScope = this
        //You can use this scope to get the minWidth, maxWidth, minHeight, maxHeight in dp and constraints

        Column {
            if (boxWithConstraintsScope.maxHeight >= 200.dp) {
                Text(
                    "This is only visible when the maxHeight is >= 200.dp",
                    style = TextStyle(fontSize = 20.sp)
                )
            }
            Text("minHeight: ${boxWithConstraintsScope.minHeight}, maxHeight: ${boxWithConstraintsScope.maxHeight},  minWidth: ${boxWithConstraintsScope.minWidth} maxWidth: ${boxWithConstraintsScope.maxWidth}")
        }
    }
}
package com.rainy.compose_learning.ui.foundation.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * @author jiangshiyu
 * @date 2022/8/18
 */

@Preview
@Composable
fun RowDemo() {

    Column(modifier = Modifier.size(200.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.width(200.dp)) {
            Text(text = "Hello World")
            Text(text = "Hello World2")
        }

        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.width(200.dp)) {
            Text(text = "Hello World")
            Text(text = "Hello World2")
        }

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.width(200.dp)) {
            Text(text = "Hello World")
            Text(text = "Hello World2")
        }
    }


}
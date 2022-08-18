package com.rainy.compose_learning.ui.foundation.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * @author jiangshiyu
 * @date 2022/8/18
 */

@Preview
@Composable
fun ColumnSample() {
    Column {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Hello World")
            Text(text = "Hello World2")
        }

        Column(
            horizontalAlignment= Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(300.dp)
                .width(200.dp)
        ) {
            Text(text = "Hello World")
            Text(text = "Hello World2")
        }
    }


}
package com.rainy.compose_learning.ui.foundation.lazy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

/**
 * @author jiangshiyu
 * @date 2022/8/19
 */


@Preview
@Composable
fun LazyRowDemo() {

    val list = listOf("A", "B", "C", "D")
    LazyRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        items(items = list, itemContent = { item ->
            Text(text = item, style = TextStyle(fontSize = 80.sp))
        })
    }
}
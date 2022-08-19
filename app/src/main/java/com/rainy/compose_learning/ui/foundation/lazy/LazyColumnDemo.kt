package com.rainy.compose_learning.ui.foundation.lazy

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
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
fun LazyColumnDemo() {
    val list = listOf("A", "B", "C", "D")
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = list, itemContent = { item ->
            Text(text = item, style = TextStyle(fontSize = 80.sp))
//            when (item) {
//                "A" -> {
//                    Text(text = item, style = TextStyle(fontSize = 80.sp))
//                }
//                "B" -> {
//                    Button(onClick = {}) {
//                        Text(text = item, style = TextStyle(fontSize = 80.sp))
//                    }
//                }
//                "C" -> {
//                    //do nothing
//                }
//                "D" -> {
//                    Text(text = item, style = TextStyle(fontSize = 80.sp))
//                }
//                else -> {
//                    Text(text = item, style = TextStyle(fontSize = 80.sp))
//                }
//        }
    })
}
}
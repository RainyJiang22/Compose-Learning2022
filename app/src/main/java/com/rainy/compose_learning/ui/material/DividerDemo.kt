package com.rainy.compose_learning.ui.material

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * @author jiangshiyu
 * @date 2022/8/25
 */

@Preview
@Composable
fun DividerDemo() {
    Column {
        Text(text = "foo")
        Divider(startIndent = 8.dp, thickness = 1.dp, color = Color.Red)
        Text(text = "bar")
    }
}
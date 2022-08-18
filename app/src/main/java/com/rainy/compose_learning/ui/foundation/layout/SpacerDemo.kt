package com.rainy.compose_learning.ui.foundation.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
fun SpacerDemo() {
    Column {
        Text(text = "Hello Word")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Hello Word2")
    }
}
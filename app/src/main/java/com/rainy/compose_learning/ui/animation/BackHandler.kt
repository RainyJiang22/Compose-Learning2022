package com.rainy.compose_learning.ui.animation

import androidx.activity.compose.BackHandler
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

/**
 * @author jiangshiyu
 * @date 2022/8/16
 */

@Preview
@Composable
fun BackHandlerDemo() {
    //计数
    var backgroundPressedCount by remember { mutableStateOf(0) }

    BackHandler(enabled = true) {
        backgroundPressedCount += 1
    }
    Text(text = "Background was pressed :$backgroundPressedCount times")
}
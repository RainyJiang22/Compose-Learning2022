package com.rainy.compose_learning.ui.material

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * @author jiangshiyu
 * @date 2022/8/24
 */

@Preview
@Composable
fun ButtonExample() {

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedButton(onClick = {}) {
            Text(text = "I am outLine Button")
        }

        TextButton(onClick = {}) {
            Text(text = "I am Text Button")
        }

    }


}
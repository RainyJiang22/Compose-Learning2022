package com.rainy.compose_learning.ui.foundation.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview

/**
 * @author jiangshiyu
 * @date 2022/8/19
 */

@Preview
@Composable
fun BaseTextField() {

    var textState by remember { mutableStateOf(TextFieldValue("Hello Word")) }


    Column {
        BasicTextField(value = textState, onValueChange = {
            textState = it
        })

        Text(text = "the textfield ")
    }

}
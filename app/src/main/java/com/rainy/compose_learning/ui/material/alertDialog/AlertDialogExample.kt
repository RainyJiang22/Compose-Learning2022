package com.rainy.compose_learning.ui.material.alertDialog

import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

/**
 * @author jiangshiyu
 * @date 2022/8/24
 */


@Composable
fun AlertDialogExample() {

    MaterialTheme {
        Column {

            val openDialog = remember { mutableStateOf(false) }

            Button(onClick = {
                openDialog.value = true
            }) {
                Text(text = "Click Me")
            }

            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = {
                        openDialog.value = false
                    },
                    title = { Text(text = "Dialog Title", textAlign = TextAlign.Center) },
                    text = { Text(text = "Here is Text") },
                    confirmButton = {
                        Button(onClick = {
                            openDialog.value = false
                        }) {
                            Text(text = "Confirm")
                        }
                    },
                    dismissButton = {
                        Button(onClick = {
                            openDialog.value = false
                        }) {
                            Text(text = "Dismiss")
                        }
                    }
                )
            }

        }
    }
}
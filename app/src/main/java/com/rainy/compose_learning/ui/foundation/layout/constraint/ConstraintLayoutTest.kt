package com.rainy.compose_learning.ui.foundation.layout.constraint

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId

/**
 * @author jiangshiyu
 * @date 2022/8/10
 */

@Preview
@Composable
fun ConstraintLayoutContent() {

    ConstraintLayout {
        val (button, text1, text2) = createRefs()

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button")
        }
        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text("Text1", Modifier.constrainAs(text1) {
            top.linkTo(button.bottom, margin = 16.dp)
        })

        Text(text = "Text2", Modifier.constrainAs(text2) {
            top.linkTo(text1.bottom, margin = 8.dp)
        })
    }
}

@Preview
@Composable
fun DecoupledConstraintLayout() {
    BoxWithConstraints {
        val constraints = if (minWidth < 600.dp) {
            decoupledConstraints(margin = 16.dp) // Portrait constraints
        } else {
            decoupledConstraints(margin = 32.dp) // Landscape constraints
        }

        ConstraintLayout(constraints) {
            Button(
                onClick = { /* Do something */ },
                modifier = Modifier.layoutId("button")
            ) {
                Text("Button")
            }

            Text("Text", Modifier.layoutId("text"))
        }
    }
}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            top.linkTo(parent.top, margin = margin)
        }
        constrain(text) {
            top.linkTo(button.bottom, margin)
        }
    }
}
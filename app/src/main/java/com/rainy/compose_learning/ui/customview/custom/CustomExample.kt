package com.rainy.compose_learning.ui.customview.custom

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rainy.compose_learning.ui.theme.ComposeLearning2022Theme

/**
 * @author jiangshiyu
 * @date 2022/8/10
 */


//地址：https://developer.android.google.cn/jetpack/compose/layouts/custom


//布局修饰符
fun Modifier.firstBaseLineToTop(firstBaselineToTop: Dp) = layout { measurable, constraints ->

    val placeable = measurable.measure(constraints)

    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
    val firstBaseline = placeable[FirstBaseline]

    val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
    val height = placeable.height + placeableY
    layout(placeable.width, height = height) {
        placeable.placeRelative(0, placeableY)
    }
}

@Preview
@Composable
fun TextWithPaddingToBaselinePreview() {
    ComposeLearning2022Theme {
        Text("Hi there!", Modifier.firstBaseLineToTop(32.dp))
    }
}

@Preview
@Composable
fun TextWithNormalPaddingPreview() {
    ComposeLearning2022Theme {
        Text("Hi there!", Modifier.padding(top = 32.dp))
    }
}


//自定义布局
@Composable
fun MyBasicColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurable, constraints ->
        val placeables = measurable.map { measurable ->
            // Measure each children
            measurable.measure(constraints)
        }
        // Set the size of the layout as big as it can
        layout(constraints.maxWidth, constraints.maxHeight) {
            // Track the y co-ord we have placed children up to
            var yPosition = 0

            // Place children in the parent layout
            placeables.forEach { placeable ->
                // Position item on the screen
                placeable.placeRelative(x = 0, y = yPosition)

                // Record the y co-ord placed up to
                yPosition += placeable.height
            }
        }
    }
}

@Preview
@Composable
fun CallingComposable(modifier: Modifier = Modifier) {
    MyBasicColumn(modifier = modifier.padding(8.dp)) {
        Text("MyBasicColumn")
        Text("places items")
        Text("vertically.")
        Text("We've done it by hand!")
    }
}
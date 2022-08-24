package com.rainy.compose_learning.ui.foundation.shape

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * @author jiangshiyu
 * @date 2022/8/24
 */

@Preview
@Composable
fun RectangleShapeDemo() {
    Column {
        ExampleBox(shape = RectangleShape)
        ExampleBox(shape = CircleShape)
        ExampleBox(shape = RoundedCornerShape(10.dp))
        ExampleBox(shape = CutCornerShape(10.dp))
    }

}

@Composable
fun ExampleBox(shape: Shape) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(shape)
                .background(Color.Red)
        )
    }
}

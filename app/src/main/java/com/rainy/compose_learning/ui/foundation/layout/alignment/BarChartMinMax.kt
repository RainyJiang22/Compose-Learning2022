package com.rainy.compose_learning.ui.foundation.layout.alignment

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rainy.compose_learning.ui.theme.ComposeLearning2022Theme
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

/**
 * AlignmentLine defined by the maximum data value in a [BarChart]
 */
val MaxChartValue = HorizontalAlignmentLine(merger = { old, new -> min(old, new) })

/**
 * AlignmentLine defined by the minimum data value in a [BarChart]
 */
val MinChartValue = HorizontalAlignmentLine(merger = { old, new -> max(old, new) })

@Composable
fun BarChartMinMax(
    dataPoints: List<Int>,
    maxText: @Composable () -> Unit,
    minText: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Layout(
        content = {
            maxText()
            minText()
            // Set a fixed size to make the example easier to follow
            BarChart(dataPoints, Modifier.size(200.dp))
        },
        modifier = modifier
    ) { measurables, constraints ->
        check(measurables.size == 3)
        val placeables = measurables.map {
            it.measure(constraints.copy(minWidth = 0, minHeight = 0))
        }

        val maxTextPlaceable = placeables[0]
        val minTextPlaceable = placeables[1]
        val barChartPlaceable = placeables[2]

        // Obtain the alignment lines from BarChart to position the Text
        val minValueBaseline = barChartPlaceable[MinChartValue]
        val maxValueBaseline = barChartPlaceable[MaxChartValue]
        layout(constraints.maxWidth, constraints.maxHeight) {
            maxTextPlaceable.placeRelative(
                x = 0,
                y = maxValueBaseline - (maxTextPlaceable.height / 2)
            )
            minTextPlaceable.placeRelative(
                x = 0,
                y = minValueBaseline - (minTextPlaceable.height / 2)
            )
            barChartPlaceable.placeRelative(
                x = max(maxTextPlaceable.width, minTextPlaceable.width) + 20,
                y = 0
            )
        }
    }
}

@Composable
fun BarChart(
    dataPoints: List<Int>,
    modifier: Modifier = Modifier
) {
    /* ... */
    val maxValue: Float = remember(dataPoints) { dataPoints.maxOrNull()!! * 1.2f }
    BoxWithConstraints(modifier = modifier) {
        val density = LocalDensity.current
        with(density) {
            // Calculate custom AlignmentLines: minYBaseline and maxYBaseline
            val yPositionRatio = remember(density, maxHeight, maxValue) {
                maxHeight.toPx() / maxValue
            }
            val xPositionRatio = remember(density, maxWidth, dataPoints) {
                maxWidth.toPx() / (dataPoints.size + 1)
            }
            val xOffset = remember(density) { // center points in the graph
                xPositionRatio / dataPoints.size
            }
            val maxYBaseline = remember(dataPoints) {
                dataPoints.maxOrNull()?.let {
                    (maxValue - it) * yPositionRatio
                } ?: 0f
            }
            val minYBaseline = remember(dataPoints) {
                dataPoints.minOrNull()?.let {
                    (maxValue - it) * yPositionRatio
                } ?: 0f
            }

            Layout(
                content = {},
                modifier = Modifier.drawBehind {
                    // Logic to draw the Chart
                }
            ) { _, constraints ->
                with(constraints) {
                    layout(
                        width = if (hasBoundedWidth) maxWidth else minWidth,
                        height = if (hasBoundedHeight) maxHeight else minHeight,
                        // Custom AlignmentLines are set here. These are propagated
                        // to direct and indirect parent composables.
                        alignmentLines = mapOf(
                            MinChartValue to minYBaseline.roundToInt(),
                            MaxChartValue to maxYBaseline.roundToInt()
                        )
                    ) {}
                }
            }
        }
    }
}

@Preview
@Composable
fun ChartDataPreview() {
    ComposeLearning2022Theme {
        BarChartMinMax(
            dataPoints = listOf(4, 24, 15),
            maxText = { Text("Max") },
            minText = { Text("Min") },
            modifier = Modifier.padding(24.dp)
        )
    }
}
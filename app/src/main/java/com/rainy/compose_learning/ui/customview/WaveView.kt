package com.rainy.compose_learning.ui.customview

import android.graphics.Typeface
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author jiangshiyu
 * @date 2022/8/16
 */

//jetpack compose 自定义绘制

/**
 * 1.通过 BoxWithConstraints 拿到父项的约束条件，即以此拿到控件允许占有的最大空间和最小空间，包括：minWidth、maxWidth、minHeight、maxHeight 等
 * 2.  Canvas() 函数来调用 drawLine、drawPath 等 API，绘制自定义图形
 * 3. 如果有些不支持，可以通过drawIntoCanvas 方法拿到原生 Android 环境的 Canvas 和 Paint 对象，利用原生 Android 环境的 API 方法来实现部分绘制需求
 */

@Composable
fun Canvas(modifier: Modifier, onDraw: DrawScope.() -> Unit) {
    Spacer(modifier = modifier.drawBehind(onDraw))
}


//绘制一条斜线
@Composable
fun DrawLine() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            start = Offset(0f, 0f),
            end = Offset(canvasWidth, canvasHeight),
            color = Color.Gray,
            strokeWidth = 10f
        )
    }
}

//绘制一个带有背景的半圆
@Composable
fun DrawPath() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val path = Path()
        path.addArc(oval = Rect(0f, 0f, canvasWidth, canvasHeight), 0f, 180f)
        //将半圆绕中心进行旋转
        rotate(degrees = 90f, pivot = center) {
            drawPath(
                path = path,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Blue,
                        Color.Cyan,
                        Color.LightGray
                    )
                )
            )
        }

        drawIntoCanvas {
            //将compose环境Paint对象转为原生paint对象
            val textPaint = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                isDither = true
                typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
                textAlign = android.graphics.Paint.Align.CENTER
            }
            textPaint.color = android.graphics.Color.RED
            textPaint.textSize = 50f
            val fontMetrics = textPaint.fontMetrics
            val top = fontMetrics.top
            val bottom = fontMetrics.bottom
            val centerX = size.width / 2f
            val centerY = size.height / 2f - top / 2f - bottom / 2f
            //拿到原生的 Canvas 对象
            val nativeCanvas = it.nativeCanvas
            nativeCanvas.drawText("学不动也要学", centerX, centerY, textPaint)
        }

    }
}


//绘制一个小圆点
fun Modifier.redPoint(pointSize: Dp): Modifier = drawWithContent {
    drawIntoCanvas {
        val paint = Paint().apply {
            color = Color.Red
        }
        it.drawCircle(
            center = Offset(size.width, 0f),
            radius = (pointSize / 2).toPx(),
            paint = paint
        )
    }
    drawContent()
}


@Preview(showBackground = true, widthDp = 160, heightDp = 160)
@Composable
fun DrawWithContentSample() {
    Spacer(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 30.dp)
            .redPoint(pointSize = 12.dp)
            .background(color = Color.LightGray)
    )
}








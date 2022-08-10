package com.rainy.compose_learning.ui.adaptive

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rainy.compose_learning.R

/**
 * @author jiangshiyu
 * @date 2022/8/10
 */

//可自适应布局
//https://developer.android.google.cn/jetpack/compose/layouts/adaptive


//灵活嵌套布局BoxWithConstraints

@Composable
fun Card(imageUrl: String, title: String, description: String) {
    BoxWithConstraints {
        if (maxWidth < 400.dp) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.ic_old_40),
                    contentDescription = null
                )
                Text(text = title)
            }
        } else {
            Row {
                Column {
                    Text(text = title)
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_old_40),
                    contentDescription = null
                )
            }
        }
    }
}
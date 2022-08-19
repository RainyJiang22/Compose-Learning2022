package com.rainy.compose_learning.ui.foundation.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rainy.compose_learning.R

/**
 * @author jiangshiyu
 * @date 2022/8/10
 */

//jetpack Compose 带来两个目标
/**
 * 1.实现高性能，2.能够自定义布局
 */

@Preview
@Composable
fun ArtistCard() {
    //Row 可以将多个水平放置在屏幕上
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_old_40),
            contentDescription = "header",
            modifier = Modifier.clip(CircleShape)
        )
        //Column 可将多个项垂直地放置在屏幕上
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = "Tallow Jacky", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "3 years ago")
        }
    }

}


//使用Box可放在其他元素的上面
@Composable
@Preview
fun ArtistAvatar() {
    Box {
        Image(painter = painterResource(id = R.drawable.ic_old_40), contentDescription = "image")
        Icon(
            painter = painterResource(id = R.drawable.ic_confirm), contentDescription = null,
            modifier = Modifier
                .size(20.dp, 20.dp)
                .align(Alignment.BottomEnd)
                .fillMaxWidth()
                .fillMaxHeight()

        )
    }
}
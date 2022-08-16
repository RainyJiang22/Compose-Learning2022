package com.rainy.compose_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rainy.compose_learning.ui.animation.BackHandlerDemo
import com.rainy.compose_learning.ui.customview.WaveLoading
import com.rainy.compose_learning.ui.layout.Message
import com.rainy.compose_learning.ui.layout.MessageCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // StartWaveLoading()
            BackHandlerDemo()
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
private fun StartConversation() {
    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xfffafafa))
        ) {
            TopBar()
            SearchBar()
            NamesBar()
        }
        NavBar()
    }
}

@Preview
@Composable
private fun StartWaveLoading() {
    Column(
        modifier = Modifier
            .verticalScroll(state = ScrollState(0))
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WaveLoading(
            modifier = Modifier.size(220.dp),
            text = "江",
            textSize = 150.sp,
            waveColor = Color(0xFF3949AB)
        )
        WaveLoading(
            modifier = Modifier.size(220.dp),
            text = "石",
            textSize = 150.sp,
            waveColor = Color.Cyan
        )
        WaveLoading(
            modifier = Modifier.size(220.dp),
            text = "雨",
            textSize = 150.sp,
            waveColor = Color.Red
        )
    }
}

@Composable
private fun NamesBar() {
    val names = listOf("Tallow Jacky", "James", "Jimmy", "Tom", "Watcher")
    val selected by remember { mutableStateOf(0) }
    LazyRow(Modifier.padding(0.dp, 8.dp), contentPadding = PaddingValues(12.dp, 0.dp)) {
        itemsIndexed(names) { index, name ->
            Column(
                Modifier
                    .padding(16.dp, 4.dp)
                    .width(IntrinsicSize.Max)
            ) {
                Text(name, color = if (index == selected) Color(0xfffa9e51) else Color(0xffb4b4b4))
                if (index == selected) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .clip(RoundedCornerShape(1.dp))
                            .background(Color(0xfffa9e51))
                    )
                }
            }
        }
    }
}

@Composable
private fun SearchBar() {
    Row(
        Modifier
            .padding(24.dp, 12.dp)
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(Color.White), verticalAlignment = Alignment.CenterVertically
    ) {
        var searchText by remember { mutableStateOf("") }
        BasicTextField(
            searchText, { searchText = it }, Modifier
                .padding(start = 24.dp)
                .weight(1f), textStyle = TextStyle(fontSize = 16.sp)
        ) {
            if (searchText.isEmpty()) {
                Text("搜搜看？", color = Color(0xffb4b4b4), fontSize = 16.sp)
            }
            it()
        }
        Box(
            Modifier
                .padding(6.dp)
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(Color(0xfffa9e51))
        ) {
            Icon(
                painterResource(R.drawable.ic_search), "搜索",
                Modifier
                    .size(24.dp)
                    .align(Alignment.Center),
                tint = Color.White
            )
        }
    }
}

@Composable
private fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(28.dp, 36.dp, 28.dp, 36.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_old_40),
            contentDescription = "头像",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Column(
            Modifier
                .padding(start = 14.dp)
                .weight(1f)
        ) {
            Text(text = "欢迎回来", fontSize = 14.sp, color = Color(0xffb4b4b4))
            Text(text = "江同学", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
        Surface(Modifier.clip(CircleShape), color = Color(0xfffef7f0)) {
            Image(
                painter = painterResource(id = R.drawable.message_new),
                contentDescription = "通知",
                modifier = Modifier
                    .padding(10.dp)
                    .size(32.dp)
            )
        }

    }
}

@Composable
private fun NavBar() {
    Row(
        modifier = Modifier
            .height(60.dp)
            .padding(horizontal = 16.dp, vertical = 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavItem(R.drawable.icon_1, Color(0xfffa9e51))
        NavItem(R.drawable.icon_2, Color(0xffb4b4b4))
        NavItem(R.drawable.icon_3, Color(0xffb4b4b4))
        NavItem(R.drawable.icon_4, Color(0xffb4b4b4))
    }
}

@Composable
private fun RowScope.NavItem(@DrawableRes res: Int, tint: Color) {
    //点击水波纹效果
    Button(
        onClick = {},
        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color.Transparent
        ),
        shape = RectangleShape
    ) {
        Icon(
            painter = painterResource(id = res),
            contentDescription = "图标",
            modifier = Modifier
                .size(24.dp)
                .weight(1f),
            tint = tint
        )
    }


}
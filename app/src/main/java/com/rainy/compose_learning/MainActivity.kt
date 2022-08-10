package com.rainy.compose_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rainy.compose_learning.ui.layout.ArtistCard
import com.rainy.compose_learning.ui.layout.Message
import com.rainy.compose_learning.ui.layout.MessageCard
import com.rainy.compose_learning.ui.layout.SampleData
import com.rainy.compose_learning.ui.theme.ComposeLearning2022Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewMessageCard()
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
fun PreviewMessageCard() {
    ComposeLearning2022Theme {
        Conversation(messages = SampleData.conversationSample)
    }
}
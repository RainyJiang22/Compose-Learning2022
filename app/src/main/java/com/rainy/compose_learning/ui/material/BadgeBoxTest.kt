package com.rainy.compose_learning.ui.material

import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

/**
 * @author jiangshiyu
 * @date 2022/8/24
 */

@Preview
@Composable
fun BadgeBoxExample() {

    BottomNavigation {
        BottomNavigationItem(selected = false, onClick = {

        }, icon = {
            BadgedBox(badge = { Badge { Text(text = "8") } }) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite"
                )
            }
        })
    }
}
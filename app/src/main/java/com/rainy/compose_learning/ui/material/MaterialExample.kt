@file:OptIn(ExperimentalMaterialApi::class)

package com.rainy.compose_learning.ui.material

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.DrawerValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FabPosition
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.material.rememberBottomDrawerState
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 * @author jiangshiyu
 * @date 2022/8/10
 */

@Composable
fun ButtonMaterial() {

    Column {
        Button(
            onClick = { /*TODO*/ },
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Like")

        }

        Spacer(modifier = Modifier.size(10.dp))

        //ExtendedFloatingActionButton ??????????????????????????? icon ??? text ??????
        ExtendedFloatingActionButton(
            onClick = { /* ... */ },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite"
                )
            },
            text = { Text("Like") }
        )

    }
}

@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            //??????topbar???TopAppBar
            TopAppBar {
                //TODO topappBar content
            }

        }, bottomBar = {
            // 50% ???????????????????????? shape ??????????????????
            BottomAppBar(
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(50.dp)
                )
            ) {
                //TODO bottomBar content
            }
        }, floatingActionButton = {
            //??????????????????
            ExtendedFloatingActionButton(text = { Text("Show SnackBar") },
                onClick = {
                    //rememberScaffoldState ???????????? ScaffoldState ?????????
                    // ????????? scaffoldState ????????????????????? Scaffold???SnackbarHostState ???????????? showSnackbar ????????????????????????
                    // ????????????????????? CoroutineScope
                    scope.launch {
//                    val result = scaffoldState.snackbarHostState.showSnackbar(
//                        message = "SnackBar",
//                        actionLabel = "Action",
//                        duration = SnackbarDuration.Indefinite
//                    )
//                    when (result) {
//                        SnackbarResult.ActionPerformed -> {
//                            //ActionPerformed
//                        }
//                        SnackbarResult.Dismissed -> {
//                            //Dismissed
//                        }
//                    }
//                    scaffoldState.snackbarHostState.showSnackbar("SnackBar")
                        // ?????? ScaffoldState ???????????????????????????????????????????????????????????????,???????????????DrawerState??????
                        scaffoldState.drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                })
        },

        //??????
        floatingActionButtonPosition = FabPosition.End,
        //?????? isFloatingActionButtonDocked ???????????????????????????????????????????????????
        isFloatingActionButtonDocked = true,
        //???????????????
        drawerContent = {
            Text("Drawer title", modifier = Modifier.padding(16.dp))
            Divider()
        },
        //??????????????????????????????
        drawerGesturesEnabled = true
    ) {
        //Screen Content
    }
}


//?????????????????????Scaffold??????????????????????????????ModelDrawer?????????

@Composable
fun ModelDrawerExample() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            //todo drawer content
        },
        drawerBackgroundColor = Color.Cyan
    ) {
        //show content
    }
//    val bottomDrawerValue = rememberBottomDrawerState(initialValue = BottomDrawerValue.Closed)
//    BottomDrawer(
//        drawerState = bottomDrawerValue,
//        drawerContent = {
//            // Drawer content
//        }
//    ) {
//        // Screen content
//    }
}


//?????????????????????,???????????????BottomSheet????????????????????????BottomSheetScaffold????????????

@Composable
fun BottomSheetExample() {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()
//    BottomSheetScaffold(
//        scaffoldState = scaffoldState,
//        sheetContent = {
//            // Sheet content
//        },
//        floatingActionButton = {
//            ExtendedFloatingActionButton(
//                text = { Text("Expand or collapse sheet") },
//                onClick = {
//                    scope.launch {
//                        scaffoldState.bottomSheetState.apply {
//                            if (isCollapsed) expand() else collapse()
//                        }
//                    }
//                }
//            )
//        }
//    ) {
//        // Screen content
//    }

    //????????????ModalBottomSheet

    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)


    Column {

    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            //Sheet Content
            Text(text = "Hello World")
            Text(text = "Hello World")
            Text(text = "Hello World")
            Text(text = "Hello World")

        }) {
        //Screen Content
        Button(
            onClick = {
                scope.launch {
                    sheetState.show()
                }
            }, contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
        ) {
            Text(text = "Open Bottom Sheet")
        }
    }

}


//?????????,????????????BackdropScaffold???????????????
@Preview
@Composable
fun BackdropExample() {
    val backdropScaffoldState =
        rememberBackdropScaffoldState(initialValue = BackdropValue.Concealed)
    val scope = rememberCoroutineScope()

    BackdropScaffold(
        scaffoldState = backdropScaffoldState,
        appBar = {
            //top app bar
            TopAppBar(
                title = { Text("Backdrop") },
                navigationIcon = {
                    if (backdropScaffoldState.isConcealed) {
                        IconButton(
                            onClick = {
                                scope.launch { backdropScaffoldState.reveal() }
                            }
                        ) {
                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    } else {
                        IconButton(
                            onClick = {
                                scope.launch { backdropScaffoldState.conceal() }
                            }
                        ) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "Close"
                            )
                        }
                    }
                },
                elevation = 0.dp,
                backgroundColor = Color.Transparent
            )

        },
        backLayerContent = {
            //back layer
        },
        frontLayerContent = {
            //front layer
        },
        peekHeight = 40.dp,
        headerHeight = 60.dp,
        gesturesEnabled = false
    ) {

    }
}

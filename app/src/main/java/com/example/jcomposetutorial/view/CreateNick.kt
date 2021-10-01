package com.example.jcomposetutorial.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jcomposetutorial.ui.theme.BabyPowder
import com.example.jcomposetutorial.ui.theme.MiddleBlue

@Composable
fun CreateNick(
    navController: NavController
) {
    Scaffold(backgroundColor = BabyPowder) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 70.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                var nick by remember { mutableStateOf("") }
                val focusManager = LocalFocusManager.current
                Text(text = "Todo.", style = MaterialTheme.typography.h2)
                Divider(color = MiddleBlue, thickness = 1.dp, modifier = Modifier.width(250.dp))
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Create Your Cool Nickname",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier
                        .padding(vertical = 15.dp, horizontal = 50.dp),
                    textAlign = TextAlign.Center
                )
                TextField(
                    value = nick,
                    textStyle = MaterialTheme.typography.body1,
                    onValueChange = { nick = it },
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = MiddleBlue,
                        focusedIndicatorColor = MiddleBlue,
                        backgroundColor = Color.Transparent
                    ),
                    placeholder = {
                        Text(text = "Nickname", style = MaterialTheme.typography.body2)
                    },
                    singleLine = true,
                    keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                )

                Box(
                    contentAlignment = Alignment.BottomEnd,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((LocalConfiguration.current.screenHeightDp / 2).dp)
                ) {
                    if (nick.length > 3) {
                        IconButton(
                            onClick = { navController.navigate("todolist") }) {
                            Icon(
                                Icons.Default.NavigateNext, contentDescription = "",
                                tint = MiddleBlue, modifier = Modifier.size(150.dp)
                            )
                        }
                    } else {
                        Text(
                            text = "Skip",
                            style = MaterialTheme.typography.h3,
                            modifier = Modifier
                                .padding(vertical = 25.dp, horizontal = 50.dp)
                                .clickable { navController.navigate("todolist") },
                        )
                    }
                }

            }


        }

    }
}
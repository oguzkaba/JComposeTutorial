package com.example.jcomposetutorial.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jcomposetutorial.ui.theme.BabyPowder
import com.example.jcomposetutorial.ui.theme.MariGold
import com.example.jcomposetutorial.ui.theme.MiddleBlue
import com.example.jcomposetutorial.view.component.TextFieldCompanent

@Composable
fun SignUpScreen(
    navController: NavController
) {
    Scaffold(backgroundColor = BabyPowder) {
        Box(contentAlignment = Alignment.BottomEnd,
            modifier = Modifier.fillMaxHeight()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Todo.", style = MaterialTheme.typography.h1)
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(40.dp))
                        .fillMaxWidth()
                        .background(color = MariGold)
                        .height(430.dp),
                    contentAlignment = Alignment.Center
                ) {
                    var uname by remember { mutableStateOf("") }
                    var email by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }
                    var password2 by remember { mutableStateOf("") }
                    LocalContext.current
                    var passwordVisibility by remember { mutableStateOf(false) }
                    val focusManager = LocalFocusManager.current

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        TextFieldCompanent(
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                            keyboardActions = KeyboardActions(onNext = {
                                focusManager.moveFocus(
                                    FocusDirection.Down
                                )
                            }),
                            value = email,
                            hint = "Email",
                            onValueChange = { email = it },
                            icon = Icons.Default.Email
                        )
                        TextFieldCompanent(
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                            keyboardActions = KeyboardActions(onNext = {
                                focusManager.moveFocus(
                                    FocusDirection.Down
                                )
                            }),
                            value = uname,
                            hint = "Username",
                            onValueChange = { uname = it },
                            icon = Icons.Default.Person
                        )
                        TextFieldCompanent(
                            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                val image = if (passwordVisibility)
                                    Icons.Filled.Visibility
                                else Icons.Filled.VisibilityOff
                                IconButton(onClick = {
                                    passwordVisibility = !passwordVisibility
                                }) {
                                    Icon(imageVector = image, "")

                                }

                            },
                            value = password,
                            hint = "Password",
                            onValueChange = { password = it },
                            icon = Icons.Default.Lock
                        )
                        TextFieldCompanent(
                            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                val image = if (passwordVisibility)
                                    Icons.Filled.Visibility
                                else Icons.Filled.VisibilityOff
                                IconButton(onClick = {
                                    passwordVisibility = !passwordVisibility
                                }) {
                                    Icon(imageVector = image, "")

                                }

                            },
                            value = password2,
                            hint = "Password",
                            onValueChange = { password2 = it },
                            icon = Icons.Default.Lock
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = {
                                navController.navigate("login")
                            },
                            modifier = Modifier.size(150.dp, 40.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = BabyPowder,
                                //contentColor = Color.White
                            )
                        ) {
                            Text(
                                text = "Sign UP",
                                color = MiddleBlue
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(text = "already have account? ", style = MaterialTheme.typography.subtitle2)
                                Text(
                                    text = "Login",
                                    style = MaterialTheme.typography.subtitle1,
                                    modifier = Modifier.clickable { navController.navigate("login") }
                                )
                        }
                    }
                }
            }


        }

    }
}
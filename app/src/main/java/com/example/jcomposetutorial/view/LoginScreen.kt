package com.example.jcomposetutorial.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
fun LoginScreen(
    navController: NavController
) {
    Scaffold(backgroundColor = BabyPowder) {
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier.fillMaxHeight()
        ) {
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
                        .height(300.dp),
                    contentAlignment = Alignment.Center
                ) {
                    var unameORemail by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }
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
                            value = unameORemail,
                            hint = "Username or email",
                            onValueChange = { unameORemail = it },
                            icon = Icons.Default.Email
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

                        TextButton(onClick = {}) {
                            Text(
                                text = "Forgot password ?",
                                style = MaterialTheme.typography.subtitle2
                            )
                        }
                        Button(
                            onClick = {
                                navController.navigate("nick")
                            },
                            modifier = Modifier.size(150.dp, 40.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = BabyPowder,
                                //contentColor = Color.White
                            )
                        ) {
                            Text(
                                text = "Login",
                                color = MiddleBlue
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "don't have account? ",
                                style = MaterialTheme.typography.subtitle2
                            )
                            Text(
                                text = "SIGN UP",
                                style = MaterialTheme.typography.subtitle1,
                                modifier = Modifier.clickable {navController.navigate("signup") }
                            )
                        }
                    }
                }
            }


        }

    }
}
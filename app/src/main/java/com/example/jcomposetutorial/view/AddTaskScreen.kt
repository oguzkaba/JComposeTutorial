package com.example.jcomposetutorial.view


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jcomposetutorial.ui.theme.BabyPowder
import com.example.jcomposetutorial.ui.theme.MiddleBlue
import com.example.jcomposetutorial.view.component.OutTextFieldCompanent

@Composable
fun AddTaskScreen(
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
                var title by remember { mutableStateOf("") }
                var content by remember { mutableStateOf("") }
                val focusManager = LocalFocusManager.current
                Text(text = "Todo.", style = MaterialTheme.typography.h2)
                TabRowDefaults.Divider(
                    color = MiddleBlue,
                    thickness = 1.dp,
                    modifier = Modifier.width(250.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Add task",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.align(Alignment.Start)
                )
                OutTextFieldCompanent(
                    value = title,
                    onValueChange = { title = it },
                    hint = "Title...",
                    maxLines = 1
                )
                OutTextFieldCompanent(
                    value = content,
                    onValueChange = { content = it },
                    hint = "Content...",
                    maxLines = 5
                )
                Box(contentAlignment = Alignment.BottomCenter,modifier = Modifier.fillMaxHeight()) {
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MiddleBlue,
                        ),
                        shape = RoundedCornerShape(30.dp)
                    ) {
                        Text(text = "DONE", color = BabyPowder)
                    }
                }


            }


        }

    }
}
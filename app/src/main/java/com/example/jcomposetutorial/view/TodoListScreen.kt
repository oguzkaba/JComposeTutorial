package com.example.jcomposetutorial.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jcomposetutorial.model.TodosItem
import com.example.jcomposetutorial.ui.theme.BabyPowder
import com.example.jcomposetutorial.ui.theme.MariGold
import com.example.jcomposetutorial.ui.theme.MiddleBlue
import com.example.jcomposetutorial.ui.theme.SalmonPink
import com.example.jcomposetutorial.viewmodel.TodosListViewModel

@ExperimentalMaterialApi
@Composable
fun TodoListScreen(
    navController: NavController,
    viewModel: TodosListViewModel = hiltViewModel()
) {
    Scaffold(
        backgroundColor = BabyPowder,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("addtodo") },
                backgroundColor = MariGold,
                content = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = true
    ) {
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier.fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp, start = 20.dp, end = 20.dp, bottom = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Todo.", style = MaterialTheme.typography.h1)
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Hey Oguz,",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.align(Alignment.Start)
                )
                TodosList()
            }
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun TodosList(
    viewModel: TodosListViewModel = hiltViewModel()
) {
    val todosList by remember { viewModel.todosList }
    val errorMessage by remember { viewModel.errorMessage }
    val isLoading by remember { viewModel.isLoading }

    TodoListView(todos = todosList)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator(color = MiddleBlue)
        }
        if (errorMessage.isNotEmpty()) {
            RetryView(error = errorMessage) {
                viewModel.loadTodos()
            }
        }
    }

}


@ExperimentalMaterialApi
@Composable
fun TodoListView(todos: List<TodosItem>) {
    LazyColumn(contentPadding = PaddingValues(5.dp)) {
        items(todos) { todo ->
            TodoRow(todo = todo)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun TodoRow(
    todo: TodosItem,
) {

    val backColor: Color
    val iconColor: Color
    val textColor: Color
    val secTextColor: Color
    val textDecor: TextDecoration

    if (todo.Completed == 0) {
        backColor = BabyPowder
        iconColor = Color.Black
        textColor = MiddleBlue
        secTextColor = MariGold
        textDecor = TextDecoration.None
    } else {
        backColor = SalmonPink
        iconColor = Color.LightGray
        textColor = Color.LightGray
        secTextColor = Color.LightGray
        textDecor = TextDecoration.LineThrough
    }

    Card(
        modifier = Modifier
            .padding(
                vertical = 10.dp
            )
            .fillMaxWidth(),
        elevation = 10.dp,
        backgroundColor = backColor
    ) {
        ListItem(
            text = {
                Text(
                    text = todo.Title,
                    color = textColor,
                    textDecoration = textDecor,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            },
            secondaryText = {
                Text(
                    text = todo.Content,
                    color = secTextColor,
                    textDecoration = textDecor,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            },
            trailing = {
                Icon(
                    imageVector = Icons.Filled.Alarm,
                    contentDescription = "",
                    tint = iconColor
                )
            }
        )
    }
}

@Composable
fun RetryView(
    error: String,
    onRetry: () -> Unit
) {
    Column {
        Text(error, color = Color.Red, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { onRetry() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Retry")
        }
    }
}
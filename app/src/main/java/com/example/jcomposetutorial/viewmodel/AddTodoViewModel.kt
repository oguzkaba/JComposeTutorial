package com.example.jcomposetutorial.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jcomposetutorial.model.TodosItem
import com.example.jcomposetutorial.repository.TodosRepository
import com.example.jcomposetutorial.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTodoViewModel @Inject constructor(
    private val repository: TodosRepository
) : ViewModel() {
    var todosList = mutableStateOf<List<TodosItem>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)


    fun addTodo(todosItem: TodosItem) {
        viewModelScope.launch {
            when (val result = repository.addTodosList(todosItem)) {
                is Resource.Success -> {
                    errorMessage.value = ""
                    isLoading.value = false
                }
                is Resource.Error -> {
                    errorMessage.value = result.message!!
                    isLoading.value = false
                }
            }
        }
    }
}



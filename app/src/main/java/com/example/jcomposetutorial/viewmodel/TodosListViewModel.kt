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
class TodosListViewModel @Inject constructor(
    private val repository:TodosRepository
) :ViewModel() {
    var todosList = mutableStateOf<List<TodosItem>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)


    init {
        loadTodos(10,0)
    }


fun loadTodos(limit: Int?, offset: Int?){
    viewModelScope.launch {
        isLoading.value=true
        when(val result=repository.getTodosList(limit,offset)){
            is Resource.Success->{
                val todoItems= result.data!!.mapIndexed{ _, item ->
                    TodosItem(item.Completed,item.Content,item.Id,item.RecordingDate,item.Title)
                }as ArrayList<TodosItem>

                errorMessage.value=""
                isLoading.value=false
                todosList.value+=todoItems
            }
            is Resource.Error->{
                errorMessage.value=result.message!!
                isLoading.value=false
            }
        }
    }
}
}
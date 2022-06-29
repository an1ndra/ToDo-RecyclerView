package com.codeavenge.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codeavenge.recyclerview.adapter.ToDo
import com.codeavenge.recyclerview.adapter.ToDoAdapter
import com.codeavenge.recyclerview.databinding.ActivityMainBinding
import com.codeavenge.recyclerview.databinding.ItemTodoBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoList = mutableListOf(
            ToDo("Follow android tutorials", false),
            ToDo("Search on Google", false),
            ToDo("Ask questions on StackOverflow", false),
            ToDo("Follow YouTube videos", false),
            ToDo("Always be motivated", false),
            ToDo("Make android studio updated", false),
            ToDo("Sleep well", false),
            ToDo("Be your choice", false),
        )
        binding.rvTodos.adapter = ToDoAdapter(todoList)
        binding.btnAddTodo.setOnClickListener {
            val title = binding.etTodo.text.toString()
            val todo = ToDo(title, false)
            todoList.add(todo)

            ToDoAdapter(todoList).notifyItemInserted(todoList.size - 1)
        }

    }
}
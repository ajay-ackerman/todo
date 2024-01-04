package com.example.todo.todo_app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.todo_app.model.Todo;
import com.example.todo.todo_app.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }   

    public Todo createTodo(Todo todo) {
         return (Todo) todoRepository.save(todo) ;
    }

    @Transactional
    public Todo updateTodo(Long id, Todo updatedTodo)  {
        Optional<Todo> existingTodo = todoRepository.findById(id);
        if (existingTodo.isPresent()) {
            Todo td =existingTodo.get();
            td.setTitle(updatedTodo.getTitle());
            td.setDescription(updatedTodo.getDescription());
            td.setCompleted(updatedTodo.getCompleted());
            // todoRepository.save(existingTodo);
            return td;
        } else {
            throw new IllegalStateException("Task not available...");
        }
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}

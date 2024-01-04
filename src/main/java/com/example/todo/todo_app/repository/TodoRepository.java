package com.example.todo.todo_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.todo.todo_app.model.Todo;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
  
}

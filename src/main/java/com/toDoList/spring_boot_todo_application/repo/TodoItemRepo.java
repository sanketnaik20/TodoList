package com.toDoList.spring_boot_todo_application.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toDoList.spring_boot_todo_application.models.TodoItem;

@Repository
public interface TodoItemRepo extends JpaRepository<TodoItem, Long>{

    
}
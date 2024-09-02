package com.toDoList.spring_boot_todo_application.service;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toDoList.spring_boot_todo_application.models.TodoItem;
import com.toDoList.spring_boot_todo_application.repo.TodoItemRepo;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepo todoItemRepo;

    public Iterable<TodoItem> getAll() {
        return todoItemRepo.findAll();
    }

    public Optional<TodoItem> getById(Long id) {
        return todoItemRepo.findById(id);
    }

    public TodoItem save(TodoItem todoItem) {
        if (todoItem.getId() == null) {
            todoItem.setCreatedAt(Instant.now());
        }
        todoItem.setUpdatedAt(Instant.now());

        return todoItemRepo.save(todoItem);
    }

    public void delete(TodoItem todoItem) {
        todoItemRepo.delete(todoItem);
    }
}

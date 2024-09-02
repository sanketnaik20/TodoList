package com.toDoList.spring_boot_todo_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.toDoList.spring_boot_todo_application.models.TodoItem;
import com.toDoList.spring_boot_todo_application.service.TodoItemService;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

@Controller
public class ToDoFormController {

    @Autowired
    TodoItemService todoItemService;
    private TodoItem item;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem item) {
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {
        TodoItem item = new TodoItem();
        item.setDescription(todoItem.getDescription());
        item.setIsComplete(todoItem.getIsComplete());
        todoItemService.save(todoItem);
        return "redirect:/";
    }
}

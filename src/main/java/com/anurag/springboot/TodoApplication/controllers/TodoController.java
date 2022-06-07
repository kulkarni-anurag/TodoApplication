package com.anurag.springboot.TodoApplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.anurag.springboot.TodoApplication.model.Todo;
import com.anurag.springboot.TodoApplication.service.TodoService;

@Controller
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "/list-todos")
    public String listTodosPage(ModelMap model){
        List<Todo> todo = service.getAllTodos();
        System.out.println(todo);
        model.addAttribute("todos", todo);
        return "list-todos";
    }

    @GetMapping(value = "/add-todo")
    public String showAddTodosPage(ModelMap model){
        model.addAttribute("todo", new Todo());
        return "todos";
    }
}

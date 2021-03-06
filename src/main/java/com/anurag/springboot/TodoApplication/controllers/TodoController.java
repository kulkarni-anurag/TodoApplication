package com.anurag.springboot.TodoApplication.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anurag.springboot.TodoApplication.model.Todo;
import com.anurag.springboot.TodoApplication.service.TodoService;

import jakarta.validation.Valid;

@Controller
public class TodoController {

    @Autowired
    private TodoService service;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    private String getLoggedInUser(ModelMap model){
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principle instanceof UserDetails){
            return ((UserDetails)principle).getUsername();
        }
        return principle.toString();
    }

    @GetMapping(value = "/list-todos")
    public String listTodosPage(ModelMap model){
        List<Todo> todo = service.getAllTodos();
        model.addAttribute("username", getLoggedInUser(model));
        model.addAttribute("todos", todo);
        return "list-todos";
    }

    @GetMapping(value = "/add-todo")
    public String showAddTodosPage(ModelMap model){
        model.addAttribute("todo", new Todo());
        return "todos";
    }

    @PostMapping(value = "/add-todo")
    public String handleAddTodo(@Valid @ModelAttribute("todo") Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todos";
        }
        service.addTodo(todo);
        return "redirect:list-todos";
    }

    @GetMapping(value = "/update-todo")
    public String showUpdateTodosPage(ModelMap model, @RequestParam int id){
        Todo todo = service.getOneTodo(id);
        model.addAttribute("todo", todo);
        return "todos";
    }

    @PostMapping(value = "/update-todo")
    public String handleUpdateTodo(@Valid @ModelAttribute("todo") Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todos";
        }
        service.updateTodo(todo);
        return "redirect:list-todos";
    }

    @GetMapping(value = "/delete-todo")
    public String deleteTodo(@RequestParam int id){
        service.deleteTodo(id);
        return "redirect:list-todos";
    }
}

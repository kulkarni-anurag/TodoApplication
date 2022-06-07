package com.anurag.springboot.TodoApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.springboot.TodoApplication.DAO.TodoDAO;
import com.anurag.springboot.TodoApplication.model.Todo;

@Service
public class TodoService {

    @Autowired
    private TodoDAO todoDAO;

    public void addTodo(Todo todo){
        todoDAO.create(todo);
    }

    public void updateTodo(Todo todo){
        todoDAO.update(todo);
    }

    public void deleteTodo(int id){
        todoDAO.delete(id);
    }

    public List<Todo> getAllTodos(){
        return todoDAO.read();
    }

    public Todo getOneTodo(int id){
        return todoDAO.read(id);
    }
}

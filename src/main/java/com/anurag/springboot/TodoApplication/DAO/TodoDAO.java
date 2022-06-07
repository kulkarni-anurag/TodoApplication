package com.anurag.springboot.TodoApplication.DAO;

import java.util.List;

import com.anurag.springboot.TodoApplication.model.Todo;

public interface TodoDAO {
    int create(Todo todo);
    int update(Todo todo);
    int delete(int id);
    List<Todo> read();
    Todo read(int id);
}

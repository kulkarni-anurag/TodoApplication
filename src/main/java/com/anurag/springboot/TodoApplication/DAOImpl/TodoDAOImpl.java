package com.anurag.springboot.TodoApplication.DAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.anurag.springboot.TodoApplication.DAO.TodoDAO;
import com.anurag.springboot.TodoApplication.model.Todo;

@Component("todoDao")
public class TodoDAOImpl implements TodoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Todo todo) {
        String sql = "INSERT INTO Todos (description, targetDate, isDone) values (?, ?, ?)";
        int create = jdbcTemplate.update(sql, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return create;
    }

    @Override
    public int update(Todo todo) {
        String sql = "UPDATE Todos SET description = ?, targetDate = ?, isDone = ? WHERE id = ?";
        int update = jdbcTemplate.update(sql, todo.getDescription(), todo.getTargetDate(), todo.isDone(), todo.getId());
        return update;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM Todos WHERE id = ?";
        int delete = jdbcTemplate.update(sql, id);
        return delete;
    }

    @Override
    public List<Todo> read() {
        String sql = "SELECT * FROM Todos";
        BeanPropertyRowMapper<Todo> rowMapper = BeanPropertyRowMapper.newInstance(Todo.class);
        List<Todo> result = jdbcTemplate.query(sql, rowMapper);
        return result;
    }

    @Override
    public Todo read(int id) {
        String sql = "SELECT * FROM Todos WHERE id = ?";
        BeanPropertyRowMapper<Todo> rowMapper = BeanPropertyRowMapper.newInstance(Todo.class);
        Todo todo = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return todo;
    }
    
}

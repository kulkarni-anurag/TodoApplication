package com.anurag.springboot.TodoApplication.model;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Todo {
    private int id;

    @NotBlank(message = "Description is required")
    @Size(min = 10, message = "Description should be at least 10 characters")
    private String description;
    private Date targetDate;
    private boolean isDone;

    public Todo() {
        super();
    }
    public Todo(int id, String description, Date targetDate, boolean isDone) {
        super();
        this.id = id;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return isDone;
    }
    
    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", description=" + description + ", targetDate=" + targetDate + ", isDone=" + isDone + "]";
    }
}

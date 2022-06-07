package com.anurag.springboot.TodoApplication.model;

import java.util.Date;

public class Todo {
    private int id;
    private String desc;
    private Date targetDate;
    private boolean isDone;

    public Todo() {
        super();
    }
    public Todo(int id, String desc, Date targetDate, boolean isDone) {
        super();
        this.id = id;
        this.desc = desc;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
        return "Todo [id=" + id + ", desc=" + desc + ", targetDate=" + targetDate + ", isDone=" + isDone + "]";
    }
}

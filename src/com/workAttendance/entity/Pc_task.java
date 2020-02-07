package com.workAttendance.entity;

import javax.persistence.*;
import java.util.Date;

//待办任务信息表
@Entity
@Table(name="pc_task")
public class Pc_task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //案件编号
    @Column(name = "caseno")
    private String caseno;

//    用户id
    @Column(name = "userid")
    private int userid;

//    案件分配时间
    @Column(name = "time")
    private Date time;

//    代办内容
    @Column(name = "todo_content")
    private String todo_content;

//    待办状态
    @Column(name = "todo_status")
    private String todo_status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaseno() {
        return caseno;
    }

    public void setCaseno(String caseno) {
        this.caseno = caseno;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTodo_content() {
        return todo_content;
    }

    public void setTodo_content(String todo_content) {
        this.todo_content = todo_content;
    }

    public String getTodo_status() {
        return todo_status;
    }

    public void setTodo_status(String todo_status) {
        this.todo_status = todo_status;
    }
}

package com.workAttendance.entity;

import javax.persistence.*;
/*
* 工作人员基本信息
* */
//测试使用的用户信息（已废弃!）
@Entity
@Table(name="workerInfo")
public class WorkerInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //    姓名
    @Column(name="name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

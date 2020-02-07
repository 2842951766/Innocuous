package com.workAttendance.entity;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;


/*
* 考勤记录表
* */
@Entity
@Table(name="workAtdcRecord")
public class WorkAtdcRecord {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //多条打卡记录对应一个人
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    //    今日打卡日期
    @Column(name="today")
    private Date today;

    //    上班打卡时间
    @Column(name="upWorkTime")
    private Date upWorkTime;

    //    上班打卡地点
    @Column(name="upWorkSpace")
    private String upWorkSpace;

    //    下班打卡时间
    @Column(name="downWorkTime")
    private Date downWorkTime;

    //    下班打卡地点
    @Column(name="downWorkSpace")
    private String downWorkSpace;

    //    外勤开始打卡时间
    @Column(name="outWorkTime")
    private Date outWorkTime;

    //    外勤开始打卡地点
    @Column(name="outWorkSpace")
    private String outWorkSpace;

    //    外勤结束打卡时间
    @Column(name="outWorkTimeDown")
    private Date outWorkTimeDown;

    //    外勤结束打卡地点
    @Column(name="outWorkSpaceDown")
    private String outWorkSpaceDown;

    //外勤说明
    @Column(name="outWorkExplain")
    private String outWorkExplain;

    //外勤图片存放(说明外勤的原因)
    @OneToMany
    private List<WorkExplain> workExplains;

    //    加班开始打卡时间
    @Column(name="overWorkTime")
    private Date overWorkTime;

    //    加班开始打卡地点
    @Column(name="overWorkSpace")
    private String overWorkSpace;

    //    加班结束打卡时间
    @Column(name="overWorkTimeDown")
    private Date overWorkTimeDown;

    //    加班结束打卡地点
    @Column(name="overWorkSpaceDown")
    private String overWorkSpaceDown;

    //加班说明
    @Column(name="overWorkExplain")
    private String overWorkExplain;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<WorkExplain> getWorkExplains() {
        return workExplains;
    }

    public void setWorkExplains(List<WorkExplain> workExplains) {
        this.workExplains = workExplains;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Date getUpWorkTime() {
        return upWorkTime;
    }

    public void setUpWorkTime(Date upWorkTime) {
        this.upWorkTime = upWorkTime;
    }

    public String getUpWorkSpace() {
        return upWorkSpace;
    }

    public void setUpWorkSpace(String upWorkSpace) {
        this.upWorkSpace = upWorkSpace;
    }

    public Date getDownWorkTime() {
        return downWorkTime;
    }

    public void setDownWorkTime(Date downWorkTime) {
        this.downWorkTime = downWorkTime;
    }

    public String getDownWorkSpace() {
        return downWorkSpace;
    }

    public void setDownWorkSpace(String downWorkSpace) {
        this.downWorkSpace = downWorkSpace;
    }

    public Date getOutWorkTime() {
        return outWorkTime;
    }

    public void setOutWorkTime(Date outWorkTime) {
        this.outWorkTime = outWorkTime;
    }

    public String getOutWorkSpace() {
        return outWorkSpace;
    }

    public void setOutWorkSpace(String outWorkSpace) {
        this.outWorkSpace = outWorkSpace;
    }

    public Date getOverWorkTime() {
        return overWorkTime;
    }

    public void setOverWorkTime(Date overWorkTime) {
        this.overWorkTime = overWorkTime;
    }

    public String getOverWorkSpace() {
        return overWorkSpace;
    }

    public void setOverWorkSpace(String overWorkSpace) {
        this.overWorkSpace = overWorkSpace;
    }

    public Date getOutWorkTimeDown() {
        return outWorkTimeDown;
    }

    public void setOutWorkTimeDown(Date outWorkTimeDown) {
        this.outWorkTimeDown = outWorkTimeDown;
    }

    public String getOutWorkSpaceDown() {
        return outWorkSpaceDown;
    }

    public void setOutWorkSpaceDown(String outWorkSpaceDown) {
        this.outWorkSpaceDown = outWorkSpaceDown;
    }

    public Date getOverWorkTimeDown() {
        return overWorkTimeDown;
    }

    public void setOverWorkTimeDown(Date overWorkTimeDown) {
        this.overWorkTimeDown = overWorkTimeDown;
    }

    public String getOverWorkSpaceDown() {
        return overWorkSpaceDown;
    }

    public void setOverWorkSpaceDown(String overWorkSpaceDown) {
        this.overWorkSpaceDown = overWorkSpaceDown;
    }

    public String getOutWorkExplain() {
        return outWorkExplain;
    }

    public void setOutWorkExplain(String outWorkExplain) {
        this.outWorkExplain = outWorkExplain;
    }


    public String getOverWorkExplain() {
        return overWorkExplain;
    }

    public void setOverWorkExplain(String overWorkExplain) {
        this.overWorkExplain = overWorkExplain;
    }
}

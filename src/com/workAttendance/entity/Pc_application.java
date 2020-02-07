package com.workAttendance.entity;

import javax.persistence.*;

//转运申请表
@Entity
@Table(name = "pc_application")
public class Pc_application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;

    //申请编号
    @Column(name = "applicationno")
    private String applicationno;

    //病死动物种类
    @Column(name = "type")
    private String type;

    //数量
    @Column(name = "number")
    private String number;

    //重量
    @Column(name = "weight")
    private String weight;

    //病死动物源
    @Column(name = "origin")
    private String origin;

    //死亡时间
    @Column(name = "time")
    private String time;

    //耳标
    @Column(name = "earlabel")
    private String earlabel;

    //是否参加政策性保险
    @Column(name = "policy")
    private String policy;

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getApplicationno() {
        return applicationno;
    }

    public void setApplicationno(String applicationno) {
        this.applicationno = applicationno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEarlabel() {
        return earlabel;
    }

    public void setEarlabel(String earlabel) {
        this.earlabel = earlabel;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }
}

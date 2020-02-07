package com.workAttendance.entity;

import javax.persistence.*;

//装袋信息表
@Entity
@Table(name = "packaging")
public class Packaging {



    //	袋子的id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;

    //案件编号
    @Column(name = "caseNo")
    private String caseNo;

    //袋子内动物数量
    @Column(name = "number")
    private int number;

    //袋子的总重量
    @Column(name = "weight")
    private double weight;

    //袋子的动物类型
    @Column(name = "kinds")
    private String kinds;

    //动物耳标号
    @Column(name = "earlable")
    private String earlable;




    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    public String getEarlable() {
        return earlable;
    }

    public void setEarlable(String earlable) {
        this.earlable = earlable;
    }
}

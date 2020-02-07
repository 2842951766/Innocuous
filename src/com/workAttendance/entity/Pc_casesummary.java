package com.workAttendance.entity;

import javax.persistence.*;
import java.util.Date;

//案件概要信息表（用于存放报案信息）
@Entity
@Table(name="pc_casesummary")
public class Pc_casesummary {
    // @Id
    // @GeneratedValue(generator = "uuid")
    // @GenericGenerator(name = "uuid", strategy = "uuid")

    // @Id
    // @GeneratedValue(generator = "sid")
    // @GenericGenerator(name = "sid", strategy = "assigned")
    // @Column(columnDefinition = "varchar(255) default 'hello'")

    // @GenericGenerator(name = "generator", strategy = "domain.pc.OrderKeyGen")
    // @Id
    // @GeneratedValue(generator = "generator")
    // @Column(unique = true, nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    报案编号
    private String caseno;
//报案人
    private String reporter;
//    死亡动物数量
    private int number;
//    报案时间
    private Date reporttime;
//    报案对象
    private String status;
//    报案图片URL
    private String imageurl;
//    报案地址
    private String address;
//    报案单位（暂时不清楚）
    private String enterprise;
//
    private String head;
//    报案人电话
    private String phone;
    private String earlabel;
//  死亡动物种类
    private String kinds;
//    总量预估
    private float weight;

    private String lenght;
//  死亡时间
//    类型转换存在问题 String -> Date
    private String deaddate;
//超过一百斤的数量
    private int boundnumber;

    private String insurance;
    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }


    public Date getReporttime() {
        return reporttime;
    }

    public void setReporttime(Date reporttime) {
        this.reporttime = reporttime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEarlabel() {
        return earlabel;
    }

    public void setEarlabel(String earlabel) {
        this.earlabel = earlabel;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }

    public String getDeaddate() {
        return deaddate;
    }

    public void setDeaddate(String deaddate) {
        this.deaddate = deaddate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBoundnumber() {
        return boundnumber;
    }

    public void setBoundnumber(int boundnumber) {
        this.boundnumber = boundnumber;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

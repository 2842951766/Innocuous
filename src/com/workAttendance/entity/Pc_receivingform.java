package com.workAttendance.entity;

import javax.persistence.*;
import java.util.Date;

//收集时的病死动物接收单
@Entity
@Table(name="pc_receivingform")
public class Pc_receivingform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //接收单信息二维码
    @Column(name = "qR_code")
    private String qR_code;

    //报告单位/个人信息
    @Column(name = "report_unit")
    private String report_unit;

    //负责人
    @Column(name = "contactperson")
    private String contactperson;

    //电话
    @Column(name = "phone")
    private String phone;

    //地址
    @Column(name = "address")
    private String address;

    //病死动物种类
    @Column(name = "types")
    private String types;

    //死亡数量
    @Column(name = "quantity")
    private int quantity;

    //死亡重量
    @Column(name = "weight")
    private Double weight;

    //死亡时间
    @Column(name = "time")
    private Date time;

    //是否参加政策性保险
    @Column(name = "policy")
    private String policy;

    //耳标号
    @Column(name = "earlabel")
    private String earlabel;

    //合计
    @Column(name = "total")
    private String total;

    //案件id
    @Column(name = "caseno")
    private String caseno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getqR_code() {
        return qR_code;
    }

    public void setqR_code(String qR_code) {
        this.qR_code = qR_code;
    }

    public String getReport_unit() {
        return report_unit;
    }

    public void setReport_unit(String report_unit) {
        this.report_unit = report_unit;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getEarlabel() {
        return earlabel;
    }

    public void setEarlabel(String earlabel) {
        this.earlabel = earlabel;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCaseno() {
        return caseno;
    }

    public void setCaseno(String caseno) {
        this.caseno = caseno;
    }
}

package com.workAttendance.entity;

import javax.persistence.*;

//养殖企业备案表
@Entity
@Table(name = "mc_farmmingenterprises")
public class Mc_farmmingenterprises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //企业代码
    @Column(name = "ecode")
    private String ecode;

    //收集站名称
    @Column(name = "name")
    private String name;

    //地址
    @Column(name = "address")
    private String address;

    //养殖种类
    @Column(name = "kinds")
    private String kinds;

    //年出栏量
    @Column(name = "quantity")
    private int quantity;

    //规模类别
    @Column(name = "scale")
    private String scale;

    //负责人姓名
    @Column(name = "contactperson")
    private String contactperson;

    //联系电话
    @Column(name = "phone")
    private String phone;

    //附件
    @Column(name = "enclosure")
    private String enclosure;

    //关联收集站
    @Column(name = "associated_c")
    private String associated_c;

    //报案登记电话
    @Column(name = "c_phone")
    private String c_phone;

    //备用报案登记电话
    @Column(name = "c_phone2")
    private String c_phone2;

    //关联收集站
    @Column(name = "associated_t")
    private String associated_t;

    //报案登记电话
    @Column(name = "t_phone")
    private String t_phone;

    //备用报案登记电话
    @Column(name = "t_phone2")
    private String t_phone2;

    //关联处理厂
    @Column(name = "associated_p")
    private String associated_p;

    //报案登记电话
    @Column(name = "p_phone")
    private String p_phone;

    //备用报案登记电话
    @Column(name = "p_phone2")
    private String p_phone2;

    //养殖企业备案号
    @Column(name = "record_number")
    private String record_number;

    @Column(name = "enclosureprivate")
    private String enclosureprivate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }


    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
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

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public String getAssociated_c() {
        return associated_c;
    }

    public void setAssociated_c(String associated_c) {
        this.associated_c = associated_c;
    }

    public String getC_phone() {
        return c_phone;
    }

    public void setC_phone(String c_phone) {
        this.c_phone = c_phone;
    }

    public String getC_phone2() {
        return c_phone2;
    }

    public void setC_phone2(String c_phone2) {
        this.c_phone2 = c_phone2;
    }

    public String getAssociated_t() {
        return associated_t;
    }

    public void setAssociated_t(String associated_t) {
        this.associated_t = associated_t;
    }

    public String getT_phone() {
        return t_phone;
    }

    public void setT_phone(String t_phone) {
        this.t_phone = t_phone;
    }

    public String getT_phone2() {
        return t_phone2;
    }

    public void setT_phone2(String t_phone2) {
        this.t_phone2 = t_phone2;
    }

    public String getAssociated_p() {
        return associated_p;
    }

    public void setAssociated_p(String associated_p) {
        this.associated_p = associated_p;
    }

    public String getP_phone() {
        return p_phone;
    }

    public void setP_phone(String p_phone) {
        this.p_phone = p_phone;
    }

    public String getP_phone2() {
        return p_phone2;
    }

    public void setP_phone2(String p_phone2) {
        this.p_phone2 = p_phone2;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRecord_number() {
        return record_number;
    }

    public void setRecord_number(String record_number) {
        this.record_number = record_number;
    }

    public String getEnclosureprivate() {
        return enclosureprivate;
    }

    public void setEnclosureprivate(String enclosureprivate) {
        this.enclosureprivate = enclosureprivate;
    }
}

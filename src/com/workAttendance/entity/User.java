package com.workAttendance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

//存放用户信息
@Entity
@Table(name="user")
@JsonIgnoreProperties({ "role" })
public class User {

//    用户id号

    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

//  用户名
    @Column(name="username")
    private String username;

//    密码
    @Column(name="password")
    private String password;

//    用户手机号
    @Column(name="phone")
    private String phone;

//    工作单位
    @Column(name="workplaceno")
    private String workplaceno;

//    单位所在省
    @Column(name="province")
    private String province;

//    单位所在市
    @Column(name="city")
    private String city;

//    单位所在区县
    @Column(name="district")
    private String district;

//    单位所在乡/镇/街道
    @Column(name="street")
    private String street;

//    单位所在村
    @Column(name="village")
    private String village;

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid", referencedColumnName = "userid"), inverseJoinColumns = @JoinColumn(name = "roleid", referencedColumnName = "roleid"))
    private List<Role> role;

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkplaceno() {
        return workplaceno;
    }

    public void setWorkplaceno(String workplaceno) {
        this.workplaceno = workplaceno;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }
}

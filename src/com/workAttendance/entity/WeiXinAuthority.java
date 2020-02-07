package com.workAttendance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

//手机端菜单权限
@Entity
@Table(name = "weiXinAuthority")
@JsonIgnoreProperties({ "role" })
public class WeiXinAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorityid;

    @ManyToOne
    @JoinColumn(name = "roleid")
    private Role role;

    //	权限名称
    @Column(name = "authorityname")
    private String authorityname;
    //权限描述
    @Column(name = "authoritydes")
    private String authoritydes;
    //权限对应的菜单
    @Column(name = "authoritymenus")
    private String authoritymenus;


    public int getAuthorityid() {
        return authorityid;
    }

    public void setAuthorityid(int authorityid) {
        this.authorityid = authorityid;
    }

    public String getAuthorityname() {
        return authorityname;
    }

    public void setAuthorityname(String authorityname) {
        this.authorityname = authorityname;
    }

    public String getAuthoritydes() {
        return authoritydes;
    }

    public void setAuthoritydes(String authoritydes) {
        this.authoritydes = authoritydes;
    }

    public String getAuthoritymenus() {
        return authoritymenus;
    }

    public void setAuthoritymenus(String authoritymenus) {
        this.authoritymenus = authoritymenus;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

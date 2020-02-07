package com.workAttendance.entity;


import javax.persistence.*;
import java.util.List;

//角色表
@Entity
@Table(name="role")
public class Role {
    @Id
    @Column(name = "roleid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleid;

//    角色描述
    @Column(name = "roledec")
    private String roledec;

    //    角色名称
    @Column(name = "rolename")
    private String rolename;

    @ManyToMany(targetEntity = User.class)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "roleid", referencedColumnName = "roleid"), inverseJoinColumns = @JoinColumn(name = "userid", referencedColumnName = "userid"))
    private List<User> user;

    @ManyToMany(targetEntity = Authority.class)
    @JoinTable(name = "role_auth", joinColumns = @JoinColumn(name = "roleid", referencedColumnName = "roleid"), inverseJoinColumns = @JoinColumn(name = "authorityid", referencedColumnName = "authorityid"))
    private List<Authority> authority;

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(List<Authority> authority) {
        this.authority = authority;
    }



    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRoledec() {
        return roledec;
    }

    public void setRoledec(String roledec) {
        this.roledec = roledec;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}

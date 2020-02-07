package com.workAttendance.entity;

import java.util.List;

import javax.persistence.*;

//cp菜单权限表
@Entity
@Table(name = "authority")
public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorityid;

//	权限名称
	@Column(name = "authorityname")
	private String authorityname;
//权限描述
	@Column(name = "authoritydes")
	private String authoritydes;
//权限对应的菜单
	@Column(name = "authoritymenus")
	private String authoritymenus;

	@ManyToMany(targetEntity = Role.class)
	@JoinTable(name = "role_auth", joinColumns = @JoinColumn(name = "authorityid", referencedColumnName = "authorityid"), inverseJoinColumns = @JoinColumn(name = "roleid", referencedColumnName = "roleid"))
	private List<Role> role;

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

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}
}

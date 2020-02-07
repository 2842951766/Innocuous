package com.workAttendance.dao.impl;

import com.workAttendance.dao.RoleDao;
import com.workAttendance.dao.UserDao;
import com.workAttendance.entity.Role;
import com.workAttendance.entity.User;
import com.workAttendance.hibernate.HibernateDaoImplORE;
import org.springframework.stereotype.Repository;

@Repository(value = "roleDao")
public class RoleDaoImpl extends HibernateDaoImplORE<Role> implements RoleDao {
}

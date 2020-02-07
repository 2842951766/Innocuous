package com.workAttendance.dao.impl;

import com.workAttendance.dao.Pc_taskDao;
import com.workAttendance.dao.Pc_taskallocationDao;
import com.workAttendance.entity.Pc_task;
import com.workAttendance.entity.Pc_taskallocation;
import com.workAttendance.hibernate.HibernateDaoImplORE;
import org.springframework.stereotype.Repository;

@Repository(value = "pc_taskDao")
public class Pc_taskDaoImpl extends HibernateDaoImplORE<Pc_task> implements Pc_taskDao {
}

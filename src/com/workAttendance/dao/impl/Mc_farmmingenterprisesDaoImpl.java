package com.workAttendance.dao.impl;

import com.workAttendance.dao.Mc_farmmingenterprisesDao;
import com.workAttendance.dao.PackagingDao;
import com.workAttendance.entity.Mc_farmmingenterprises;
import com.workAttendance.entity.Packaging;
import com.workAttendance.hibernate.HibernateDaoImplORE;
import org.springframework.stereotype.Repository;

@Repository(value = "mc_farmmingenterprisesDao")
public class Mc_farmmingenterprisesDaoImpl extends HibernateDaoImplORE<Mc_farmmingenterprises> implements Mc_farmmingenterprisesDao {
}

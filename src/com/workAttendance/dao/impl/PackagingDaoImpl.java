package com.workAttendance.dao.impl;

import com.workAttendance.dao.PackagingDao;
import com.workAttendance.dao.Pc_casesummaryDao;
import com.workAttendance.entity.Packaging;
import com.workAttendance.entity.Pc_casesummary;
import com.workAttendance.hibernate.HibernateDaoImplORE;
import org.springframework.stereotype.Repository;

@Repository(value = "packagingDao")
public class PackagingDaoImpl extends HibernateDaoImplORE<Packaging> implements PackagingDao {
}

package com.workAttendance.service;

import com.workAttendance.entity.Mc_farmmingenterprises;
import com.workAttendance.hibernate.service.HibernateService;

import java.util.Map;

public interface Mc_farmmingenterprisesService extends HibernateService<Mc_farmmingenterprises> {
    public Mc_farmmingenterprises selectByCaseNo(Map<String, String[]> parametes);
}

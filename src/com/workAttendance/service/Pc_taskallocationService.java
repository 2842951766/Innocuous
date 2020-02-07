package com.workAttendance.service;

import com.workAttendance.dao.Pc_taskallocationDao;
import com.workAttendance.entity.Pc_casesummary;
import com.workAttendance.entity.Pc_taskallocation;
import com.workAttendance.hibernate.service.HibernateService;

import java.util.Map;

public interface Pc_taskallocationService extends HibernateService<Pc_taskallocation> {
    public  Pc_taskallocation[]  selectNeedDealInfo(Map<String, String[]> parametes);
}

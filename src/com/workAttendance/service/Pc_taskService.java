package com.workAttendance.service;

import com.workAttendance.entity.Pc_task;
import com.workAttendance.entity.Pc_taskallocation;
import com.workAttendance.hibernate.service.HibernateService;

import java.util.Map;

public interface Pc_taskService extends HibernateService<Pc_task> {
    public  Pc_task[]  selectNeedDealInfo(Map<String, String[]> parametes);
}

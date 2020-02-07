package com.workAttendance.service;

import com.workAttendance.entity.Pc_casesummary;
import com.workAttendance.hibernate.service.HibernateService;

import java.util.Map;

public interface Pc_casesummaryService extends HibernateService<Pc_casesummary> {
//    报案
    public  String  reportCase(Map<String, String[]> parametes);
//    查询案件信息
    public Pc_casesummary[] selectCaseBycaseNo(Map<String, String[]> parametes);
}

package com.workAttendance.service;

import com.workAttendance.entity.WorkAtdcRecord;
import com.workAttendance.hibernate.service.HibernateService;

import java.util.List;

public interface WorkAtdcRecordService extends HibernateService<WorkAtdcRecord> {
    //通过某个时间，或者时间段进行查询
    //先用字符串格式代替时间格式
    //如果firstTime==endTime则表示查询某天数据
    List<WorkAtdcRecord> findByTimeUpWork(String firstTime, String endTime,int id);
}

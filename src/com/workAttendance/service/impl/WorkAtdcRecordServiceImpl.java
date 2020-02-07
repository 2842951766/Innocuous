package com.workAttendance.service.impl;

import com.workAttendance.dao.WorkAtdcRecordDao;
import com.workAttendance.dao.WorkerInfoDao;
import com.workAttendance.entity.WorkAtdcRecord;
import com.workAttendance.entity.WorkerInfo;
import com.workAttendance.hibernate.dao.HibernateDao;
import com.workAttendance.hibernate.service.impl.HibernateServiceImpl;
import com.workAttendance.service.WorkAtdcRecordService;
import com.workAttendance.service.WorkerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service(value = "workAtdcRecordService")
public class WorkAtdcRecordServiceImpl extends HibernateServiceImpl<WorkAtdcRecord> implements WorkAtdcRecordService {

    @Autowired
    @Qualifier(value="workAtdcRecordDao")
    private WorkAtdcRecordDao workAtdcRecordDao;


    @Autowired
    @Qualifier(value="workerInfoDao")
    private WorkerInfoDao workerInfoDao;
    private static WorkerInfoDao workerInfoDao2;

    @Override
    public HibernateDao<WorkAtdcRecord> getHibernateDao() {
        return workAtdcRecordDao;
    }


    /*
    * firstTime：开始时间 格式YYYY-MMMM-DDDD
    * endTime：结束时间 格式YYYY-MMMM-DDDD
    * id：用户id
    * */
    @Override
    public List<WorkAtdcRecord> findByTimeUpWork(String firstTime, String endTime,int id) {
        //查询某一天的记录
        if(firstTime.trim().equals(endTime.trim())){
            SimpleDateFormat sdfTwo = new SimpleDateFormat("yyyy-MM-dd");
            String hql = "from WorkAtdcRecord M where date_format(M.today,'%Y-%m-%d') = '" + firstTime.trim()+"' and M.user.id =" + id;
            return workAtdcRecordDao.findByHQL(hql);
        }else {
            //查询某个时间段的打卡记录
            String hql = "from WorkAtdcRecord M where M.user.id = "+ id +"and M.today between '" + firstTime + "' and '"  + endTime +"' ";
            return workAtdcRecordDao.findByHQL(hql);
        }
    }

}

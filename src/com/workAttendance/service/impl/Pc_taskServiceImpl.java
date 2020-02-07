package com.workAttendance.service.impl;

import com.workAttendance.dao.Pc_taskDao;
import com.workAttendance.dao.Pc_taskallocationDao;
import com.workAttendance.entity.Pc_task;
import com.workAttendance.entity.Pc_taskallocation;
import com.workAttendance.hibernate.dao.HibernateDao;
import com.workAttendance.hibernate.service.impl.HibernateServiceImpl;
import com.workAttendance.service.Pc_taskService;
import com.workAttendance.service.Pc_taskallocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

@Service(value = "pc_taskService")
public class Pc_taskServiceImpl extends HibernateServiceImpl<Pc_task> implements Pc_taskService {

    @Autowired
    @Qualifier(value="pc_taskDao")
    private Pc_taskDao pc_taskDao;

    @Override
    public HibernateDao<Pc_task> getHibernateDao() {
        return pc_taskDao;
    }

    @Override
    public Pc_task[] selectNeedDealInfo(Map<String, String[]> parametes) {
        //        用户的id
        int id = -1;
        String hql = "";
        try {
            id  = Integer.parseInt(URLDecoder.decode(parametes.get("id")[0],"utf-8"));
            hql = "from Pc_task M where M.userid =  "+ id;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<Pc_task> pc_taskList = pc_taskDao.findByHQL(hql);
        if(pc_taskList.size()>0){
            return pc_taskList.toArray(new Pc_task[pc_taskList.size()]);
        }else {
            return new Pc_task[]{};
        }
    }
}

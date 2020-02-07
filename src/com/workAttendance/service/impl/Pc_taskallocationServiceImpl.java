package com.workAttendance.service.impl;

import com.workAttendance.dao.Pc_casesummaryDao;
import com.workAttendance.dao.Pc_taskallocationDao;
import com.workAttendance.entity.Pc_casesummary;
import com.workAttendance.entity.Pc_taskallocation;
import com.workAttendance.entity.User;
import com.workAttendance.hibernate.dao.HibernateDao;
import com.workAttendance.hibernate.service.impl.HibernateServiceImpl;
import com.workAttendance.service.Pc_casesummaryService;
import com.workAttendance.service.Pc_taskallocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

@Service(value = "Pc_taskallocationService")
public class Pc_taskallocationServiceImpl extends HibernateServiceImpl<Pc_taskallocation> implements Pc_taskallocationService {

    @Autowired
    @Qualifier(value="pc_taskallocationDao")
    private Pc_taskallocationDao pc_taskallocationDao;

//    查询我的待办信息
    @Override
    public  Pc_taskallocation[]  selectNeedDealInfo(Map<String, String[]> parametes) {
//        用户的id
        String caseno = "";
        String hql = "";
        try {
            caseno  = URLDecoder.decode(parametes.get("caseno")[0],"utf-8");
            hql = "from Pc_taskallocation M where M.caseno =  '"+ caseno + "'";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<Pc_taskallocation> pc_taskallocationList = pc_taskallocationDao.findByHQL(hql);
        if(pc_taskallocationList.size()>0){
            return pc_taskallocationList.toArray(new Pc_taskallocation[pc_taskallocationList.size()]);
        }else {
            return new Pc_taskallocation[]{};
        }
    }

    @Override
    public HibernateDao<Pc_taskallocation> getHibernateDao() {
        return null;
    }
}

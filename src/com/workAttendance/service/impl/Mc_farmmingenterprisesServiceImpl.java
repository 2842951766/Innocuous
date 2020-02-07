package com.workAttendance.service.impl;

import com.workAttendance.dao.Mc_farmmingenterprisesDao;
import com.workAttendance.dao.Pc_casesummaryDao;
import com.workAttendance.dao.UserDao;
import com.workAttendance.entity.Mc_farmmingenterprises;
import com.workAttendance.entity.Pc_casesummary;
import com.workAttendance.entity.User;
import com.workAttendance.hibernate.dao.HibernateDao;
import com.workAttendance.hibernate.service.impl.HibernateServiceImpl;
import com.workAttendance.service.Mc_farmmingenterprisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

@Service(value = "mc_farmmingenterprisesService")
public class Mc_farmmingenterprisesServiceImpl extends HibernateServiceImpl<Mc_farmmingenterprises> implements Mc_farmmingenterprisesService {

    @Autowired
    @Qualifier(value="mc_farmmingenterprisesDao")
    private Mc_farmmingenterprisesDao mc_farmmingenterprisesDao;

    @Autowired
    @Qualifier(value="userDao")
    private UserDao userDao;

    @Autowired
    @Qualifier(value="pc_casesummaryDao")
    private Pc_casesummaryDao pc_casesummaryDao;

//    通过案件id查询养殖企业备案信息
    @Override
    public Mc_farmmingenterprises selectByCaseNo(Map<String, String[]> parametes){
        //        案件编号
        String caseNo;
        //报案人
        String reporter = null;
        //报案人电话
        String phone = null;
        //养殖企业备案号
        String record_number = null;
        String hqlCase = null;
        String hqlUser = null;
        String hqlFarm = null;
        try {
            caseNo  = URLDecoder.decode(parametes.get("caseNo")[0],"utf-8");
            hqlCase = "from Pc_casesummary M where M.caseno = '" + caseNo + "'";
            //获取案件概要信息
            List<Pc_casesummary> pc_casesummaryList = pc_casesummaryDao.findByHQL(hqlCase);
            reporter = pc_casesummaryList.get(0).getReporter();
            phone = pc_casesummaryList.get(0).getPhone();

            hqlUser = "from User M where M.phone = '" + phone + "' and M.username = '" + reporter + "'";
            List<User> userList = userDao.findByHQL(hqlUser);
            record_number = userList.get(0).getWorkplaceno();

            hqlFarm = "from Mc_farmmingenterprises M where M.record_number =  '" + record_number +"'";



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<Mc_farmmingenterprises> mc_farmmingenterprisesList = mc_farmmingenterprisesDao.findByHQL(hqlFarm);
        return mc_farmmingenterprisesList.get(0);
    }

    @Override
    public HibernateDao<Mc_farmmingenterprises> getHibernateDao() {
        return mc_farmmingenterprisesDao;
    }
}

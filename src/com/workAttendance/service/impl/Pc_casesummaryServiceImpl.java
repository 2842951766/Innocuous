package com.workAttendance.service.impl;

import com.workAttendance.dao.Pc_casesummaryDao;
import com.workAttendance.dao.RoleDao;
import com.workAttendance.entity.Pc_casesummary;
import com.workAttendance.entity.Pc_task;
import com.workAttendance.entity.Role;
import com.workAttendance.entity.User;
import com.workAttendance.hibernate.dao.HibernateDao;
import com.workAttendance.hibernate.service.impl.HibernateServiceImpl;
import com.workAttendance.service.Pc_casesummaryService;
import com.workAttendance.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(value = "pc_casesummary")
public class Pc_casesummaryServiceImpl extends HibernateServiceImpl<Pc_casesummary> implements Pc_casesummaryService {

    @Autowired
    @Qualifier(value="pc_casesummaryDao")
    private Pc_casesummaryDao pc_casesummaryDao;

//  根据案件编号查询案件信息
    @Override
    public Pc_casesummary[] selectCaseBycaseNo(Map<String, String[]> parametes){
//        案件编号
        String caseNo;
        String hql = null;
        try {
            caseNo  = URLDecoder.decode(parametes.get("caseNo")[0],"utf-8");
            hql = "from Pc_casesummary M where M.caseno = '" + caseNo + "'";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<Pc_casesummary> pc_casesummaryList = pc_casesummaryDao.findByHQL(hql);
        if(pc_casesummaryList.size()>0){
            return pc_casesummaryList.toArray(new Pc_casesummary[pc_casesummaryList.size()]);
        }else {
            return new Pc_casesummary[]{};
        }
    }

//    用户发起报案请求
    @Override
    public  String  reportCase(Map<String, String[]> parametes) {
//        报案编号
        String caseno ;
//        养殖户地址
        String address = "";
//        报案人姓名
        String reporter = "";
//        死亡动物种类
        String kinds = "";
//        报案人电话
        String phone = "";
//      死亡动物数量
        int number;
//      总量预估
        float weight;
//      一百斤以上的头数
        int boundnumber;
//        死亡时间
        String deaddate;
//        报案时间
        Date reporttime;
        try {
            try {
                address  = URLDecoder.decode(parametes.get("address")[0],"utf-8");
                reporter  = URLDecoder.decode(parametes.get("reporter")[0],"utf-8");
            }catch (Exception e){}
            kinds  = URLDecoder.decode(parametes.get("kinds")[0],"utf-8");
            phone  = URLDecoder.decode(parametes.get("phone")[0],"utf-8");
            number  = Integer.parseInt(URLDecoder.decode(parametes.get("number")[0],"utf-8"));
            weight  = Float.parseFloat(URLDecoder.decode(parametes.get("weight")[0],"utf-8"));
            boundnumber  = Integer.parseInt(URLDecoder.decode(parametes.get("boundnumber")[0],"utf-8"));
            reporttime = new Date();
            caseno = this.produceCaseNo("1","anhui");
            deaddate  = parametes.get("deaddate")[0];

//            信息注入对象
            Pc_casesummary pc_casesummary = new Pc_casesummary();
            pc_casesummary.setAddress(address);
            pc_casesummary.setReporter(reporter);
            pc_casesummary.setKinds(kinds);
            pc_casesummary.setPhone(phone);
            pc_casesummary.setNumber(number);
            pc_casesummary.setWeight(weight);
            pc_casesummary.setBoundnumber(boundnumber);
            pc_casesummary.setDeaddate(deaddate);
            pc_casesummary.setReporttime(reporttime);
            pc_casesummary.setCaseno(caseno);
            pc_casesummaryDao.save(pc_casesummary);
//            报案成功提示
            return "success";
        }catch (Exception e){
        }
//报案失败提示
        return "error";
    }

//    案件编号生成规则(caseno)
    /*
    * caseType:报案类型
    * placeName：报案地点名称
    * */
    private String produceCaseNo(String caseType,String placeName){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(new Date());
        String caseNo = caseType+placeName+currentTime;
        return caseNo.replace("-","").replace(":","").replace(" ","");
    }

    @Override
    public HibernateDao<Pc_casesummary> getHibernateDao() {
        return null;
    }
}

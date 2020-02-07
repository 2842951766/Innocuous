package com.workAttendance.service.impl;

import com.workAttendance.dao.UserDao;
import com.workAttendance.dao.WeiXinAuthorityDao;
import com.workAttendance.entity.User;
import com.workAttendance.entity.WeiXinAuthority;
import com.workAttendance.hibernate.dao.HibernateDao;
import com.workAttendance.hibernate.service.impl.HibernateServiceImpl;
import com.workAttendance.service.UserService;
import com.workAttendance.service.WeiXinAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(value = "weiXinAuthorityService")
public class WeiXinAuthorityServiceImpl extends HibernateServiceImpl<WeiXinAuthority> implements WeiXinAuthorityService {


    @Autowired
    @Qualifier(value="weiXinAuthorityDao")
    private WeiXinAuthorityDao weiXinAuthorityDao;

//    查询微信用户菜单权限
    @Override
    public WeiXinAuthority[] selectWeiXinAuthority(Map<String, String[]> parametes){
        List<WeiXinAuthority> weiXinAuthorityList = new ArrayList<WeiXinAuthority>();
//        查询用户角色sql语句
        String sql = "select roleid from user_role where userid = ";
//        获取前台传来的用户id
        int userid;
        try {
            userid = Integer.parseInt(parametes.get("userid")[0]);
            sql = sql + userid;
            List<Object> rolenids =  weiXinAuthorityDao.findBySQL(sql);

//            查询用户权限
            for(Object item : rolenids){
                String hql = "from WeiXinAuthority M where M.role.roleid = " + (int)item;
                List<WeiXinAuthority> tempList = weiXinAuthorityDao.findByHQL(hql);
//                遍历出所有的用户权限
                for(WeiXinAuthority weiXinAuthority : tempList){
                    weiXinAuthorityList.add(weiXinAuthority);
                }

            }
        }catch (Exception e){}

        if(weiXinAuthorityList.size()>0){
            return weiXinAuthorityList.toArray(new WeiXinAuthority[weiXinAuthorityList.size()]);
        }else {
            return new WeiXinAuthority[]{};
        }

    }

    @Override
    public HibernateDao<WeiXinAuthority> getHibernateDao() {
        return null;
    }
}

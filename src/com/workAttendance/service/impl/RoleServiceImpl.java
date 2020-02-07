package com.workAttendance.service.impl;

import com.workAttendance.dao.RoleDao;
import com.workAttendance.dao.UserDao;
import com.workAttendance.entity.Role;
import com.workAttendance.entity.User;
import com.workAttendance.entity.WeiXinAuthority;
import com.workAttendance.hibernate.dao.HibernateDao;
import com.workAttendance.hibernate.service.impl.HibernateServiceImpl;
import com.workAttendance.service.RoleService;
import com.workAttendance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "roleService")
public class RoleServiceImpl extends HibernateServiceImpl<Role> implements RoleService {

    @Autowired
    @Qualifier(value="roleDao")
    private RoleDao roleDao;

    @Override
    public HibernateDao<Role> getHibernateDao() {
        return roleDao;
    }


    //根据用户id确定用户是否是报案主体管理员，监管员，收集员其中的一个
    @Override
    public String getRole(int userid){
        List<WeiXinAuthority> weiXinAuthorityList = new ArrayList<WeiXinAuthority>();
//        查询用户角色sql语句
        String sql = "select roleid from user_role where userid = ";
        try {
            sql = sql + userid;
            List<Object> rolenids =  roleDao.findBySQL(sql);

//            查询用户权限
            for(Object item : rolenids){
                String hql = "from Role M where M.roleid = " + (int)item;
                List<Role> tempList = roleDao.findByHQL(hql);
//                遍历出所有的用户权限
                for(Role role : tempList){
                    if(role.getRolename().trim().equals("监管员")){
                        return "controler";
                    }else if(role.getRolename().trim().equals("收集员")){
                        return "collecter";
                    }else if(role.getRolename().trim().equals("报案主体管理员")){
                        return "owner";
                    }
                }

            }
        }catch (Exception e){

        }

        return null;

    }
}

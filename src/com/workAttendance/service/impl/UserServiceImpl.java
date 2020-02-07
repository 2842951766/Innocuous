package com.workAttendance.service.impl;

import com.workAttendance.dao.UserDao;
import com.workAttendance.dao.WorkAtdcRecordDao;
import com.workAttendance.entity.User;
import com.workAttendance.entity.WorkAtdcRecord;
import com.workAttendance.hibernate.dao.HibernateDao;
import com.workAttendance.hibernate.service.impl.HibernateServiceImpl;
import com.workAttendance.service.UserService;
import com.workAttendance.service.WorkAtdcRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(value = "userService")
public class UserServiceImpl extends HibernateServiceImpl<User> implements UserService {

    @Autowired
    @Qualifier(value="userDao")
    private UserDao userDao;

//    验证用户登录,获取用户信息
    @Override
    public  User[]  checkUserInfo(Map<String, String[]> parametes)  {
        String hql = "from User M where M.phone = ";
        List<Object> param = new ArrayList<Object>();
//        用户的电话号码
        String phone ;
//        用户姓名
        String username ;
        try {
            phone  = URLDecoder.decode(parametes.get("phone")[0],"utf-8");
            username  = URLDecoder.decode(parametes.get("username")[0],"utf-8");
//            如果电话不为空
            if(!phone.trim().equals("")&&!username.trim().equals("")){
                hql = hql + "'" + phone + "' and M.username = '" + username +" '";
            }else {
//                如果电话或姓名为空
                return new User[]{};
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List <User> userList = userDao.findByHQL(hql,param.toArray());

        if(userList.size()>0){
            return userList.toArray(new User[userList.size()]);
        }else {
            return new User[]{};
        }
    }

    @Override
    public HibernateDao<User> getHibernateDao() {
        return userDao;
    }
}

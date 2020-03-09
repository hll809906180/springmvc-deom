package cn.leadeon.sys.service;

import cn.leadeon.sys.dao.UserDao;
import cn.leadeon.sys.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<UserEntity> getUser(Map params){
      //  userDao.choseSqlClient("sqlSessionFactory1");
        return  userDao.findList(params);
    }
}

package cn.leadeon.sys.dao;

import cn.leadeon.comm.dao.AbstractGenericDao;
import cn.leadeon.sys.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao extends AbstractGenericDao<UserEntity> {

    public List<UserEntity> findList(Map params){
        return  this.getSqlSession().selectList(getNameSpace() + ".find",params);
    }

}

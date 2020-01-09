package cn.leadeon.comm.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

public class AbstractGenericDao<T> extends SqlSessionDaoSupport implements ApplicationContextAware {

    private Class<T> clazz;

    private ApplicationContext context;

    public ApplicationContext getContext(){
        return context;
    }

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    /**
     * 切换数据源
     *
     * @param name
     *         传递sqlMapClient或sqlMapClient2
     * @see
     */
    public void choseSqlClient(String name) {
        SqlSessionFactory client = (SqlSessionFactory) getContext().getBean(name);
        super.setSqlSessionTemplate(new SqlSessionTemplate(client));
        afterPropertiesSet();
    }

    // 通过范型反射，取得在子类中定义的class.
    protected String getNameSpace() {
        clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz.getSimpleName();
    }



    /**
     * 新增对象
     */
    public T save(T entity) {
        getSqlSession().insert(getNameSpace() + ".save", entity);
        return entity;
    }

    /**
     * 更新对象
     */
    public T update(T entity) {
        getSqlSession().update(getNameSpace() + ".update", entity);
        return entity;
    }

    /**
     * 根据ID删除对象
     */
    public void removeById(Serializable id) {
        getSqlSession().delete(getNameSpace() + ".delete", id);
    }

    /**
     * 查询总数
     */
    public Long getTotalCount(Map params) {
        Long count = (Long)getSqlSession().selectOne(getNameSpace() + ".totalCount", params);
        return (count == null ? 0 : count);
    }

    /**
     * 查询列表
     */
    public List<T> find(Map params){
        return  this.getSqlSession().selectList(getNameSpace() + ".find",params);
    }

    /***
     * 查询对象
     */
    public T get(Serializable id) {
        T entity = (T) getSqlSession().selectOne(getNameSpace() + ".get", id);
        return entity;
    }
}

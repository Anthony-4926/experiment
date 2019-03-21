package com.example.experiment.ex_02.repository;


import com.example.experiment.ex_02.entity.Address02;
import com.example.experiment.ex_02.entity.User02;
import com.example.experiment.ex_02.entity.User02Address02;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author 赵鑫
 * @create 2019-03-20 19:48
 */
@Slf4j
@Repository
@Transactional
public class ex_02_UserRepository {
    @PersistenceContext
    private EntityManager em;


    /**
     * 添加用户，并返回包括数据库时间戳的用户对象
     *
     * @param user
     * @return
     */
    public User02 addUser(User02 user) {
        em.persist(user);
        em.refresh(user);
        return user;
    }

    /**
     * 添加地址，并指定地址对应的用户
     *
     * @param address
     * @param uid
     * @return
     */
    public Address02 addAddress(Address02 address, int uid) {
       address = em.merge(address);
        User02 user = em.find(User02.class, uid);
        User02Address02 user02Address02 = new User02Address02(address, user);
        em.persist(user02Address02);
        return address;
    }

    /**
     * 更新指定ID用户的姓名
     *
     * @param uid
     * @param newName
     * @return
     */
    public User02 updateUser(int uid, String newName) {
        User02 user = em.find(User02.class, uid);
        user.setName(newName);
        em.flush();

        return user;
    }

    /**
     * 尝试使用merge()，以及find()2种方法分别实现
     * 更新指定地址为指定用户
     *
     * @param aid
     * @param uid
     * @return
     */
    public Address02 updateAddress(int aid, int uid) {
        Address02 add = new Address02();
        add.setId(aid);
        add = em.merge(add);
        em.refresh(add);

        User02 user = new User02();
        user.setId(uid);
        user = em.merge(user);
        em.refresh(user);

        List<User02Address02> ud = user.getUserAddresses();
        Address02 finalAdd = add;
        ud.forEach(u->{
            u.setAddress(finalAdd);
        });

        return add;
    }

    /**
     * 返回指定用户的全部地址，没有返回空集合，而非null
     *
     * @param uid
     * @return
     */
    public List<Address02> listAddresses(int uid) {
        List<Address02> result;
        String jpql = "SELECT ud.address FROM User02Address02 ud WHERE ud.user.id=?1";
        Query query = em.createQuery(jpql);
        result = query.setParameter(1, uid).getResultList();
        return result;
    }

    public void removeAddress(int aid) {

        String jpql = "DELETE FROM Address02 a WHERE a.id=?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, aid).executeUpdate();
    }

    /**
     * 删除用户，设置级联操作或手动删除相关地址
     *
     * @param uid
     */
    public void remaveUser(int uid) {
        String jpql = "DELETE FROM User02 u WHERE u.id=?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, uid).executeUpdate();
    }
}

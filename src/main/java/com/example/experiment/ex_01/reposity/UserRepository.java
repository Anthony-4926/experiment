package com.example.experiment.ex_01.reposity;

import com.example.experiment.ex_01.entity.Address01;
import com.example.experiment.ex_01.entity.User01;
import com.example.experiment.ex_01.entity.User01Address01;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author 赵鑫
 * @create 2019-03-19 17:13
 */
@Repository
@Transactional
@Getter
@Setter

public class UserRepository {
    @PersistenceContext
    EntityManager em;

    public void insertUserAddress() {
        User01 user = new User01("BO");
        em.persist(user);
        user.setName("wangbo");
        em.flush();
        User01 user1 = new User01("zhaoxin");
        em.persist(user1);

        Address01 address = new Address01("956");
        em.persist(address);

        Address01 address1 = new Address01("923");
        em.persist(address1);

        User01Address01 userAddress = new User01Address01(address, user);
        em.persist(userAddress);
        User01Address01 userAddress2 = new User01Address01(address, user1);
        em.persist(userAddress2);
        User01Address01 userAddress1 = new User01Address01(address1, user);
        em.persist(userAddress1);
        User01Address01 userAddress3 = new User01Address01(address1, user1);
        em.persist(userAddress3);
    }

}

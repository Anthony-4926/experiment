package com.example.experiment;

import com.example.experiment.ex_01.reposity.UserRepository;
import com.example.experiment.ex_02.entity.Address02;
import com.example.experiment.ex_02.entity.User02;
import com.example.experiment.ex_02.repository.ex_02_UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 赵鑫
 * @create 2019-03-19 18:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ex_02_UserRepository ex_02_userRepository;

    @Test
    public void test() {
        userRepository.insertUserAddress();
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void test2() {
        ex_02_userRepository.updateUser(2, "李四");
        ex_02_userRepository.updateAddress(2,1);
        List<Address02> list = ex_02_userRepository.listAddresses(2);
        list.forEach(l->{
            log.debug("",l.getDetail());
        });

        ex_02_userRepository.removeAddress(1);
        ex_02_userRepository.remaveUser(1);
    }




    @Test
    public  void insert() {
        User02 user = new User02("BO");
        User02 user1 = new User02("zhaoxin");
        Address02 address = new Address02("956");
        Address02 address1 = new Address02("923");
        user = ex_02_userRepository.addUser(user);
        user1 = ex_02_userRepository.addUser(user1);
        address = ex_02_userRepository.addAddress(address, user.getId());
        ex_02_userRepository.addAddress(address, user1.getId());
        address1 = ex_02_userRepository.addAddress(address1, user.getId());
        ex_02_userRepository.addAddress(address1, user1.getId());
    }



}

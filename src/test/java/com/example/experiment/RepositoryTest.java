package com.example.experiment;

import com.example.experiment.ex_01.reposity.UserRepository;
import com.example.experiment.ex_02.entity.Address02;
import com.example.experiment.ex_02.repository.ex_02_UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void test2() {
//        ex_02_userRepository.insertUserAddress();

        List<Address02> list =  ex_02_userRepository.listAddresses(1);
        log.debug(String.valueOf(list.size()));
        System.out.println(list.size());
    }



}

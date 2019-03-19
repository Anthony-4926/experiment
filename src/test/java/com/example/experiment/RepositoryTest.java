package com.example.experiment;

import com.example.experiment.ex_01.reposity.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 赵鑫
 * @create 2019-03-19 18:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        userRepository.insertUserAddress();
    }



}

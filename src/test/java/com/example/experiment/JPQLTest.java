package com.example.experiment;

import com.example.experiment.ex_03.entity.Address03;
import com.example.experiment.ex_03.entity.User03;
import com.example.experiment.ex_03.entity.User03Address03;
import com.example.experiment.ex_03.reposity.Address03Reposity;
import com.example.experiment.ex_03.reposity.User03Address03Reposity;
import com.example.experiment.ex_03.reposity.User03Reposity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 赵鑫
 * @create 2019-03-25 11:22
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JPQLTest {
    @Autowired
    private Address03Reposity addressRepository;
    @Autowired
    private User03Reposity userReposityory;
    @Autowired
    private User03Address03Reposity userAddressRepository;
    @Test
    public void init() {
        User03 user = new User03("BO");
        userReposityory.save(user);
        User03 user2 = new User03("SUN");
        userReposityory.save(user2);

        Address03 a = new Address03("956");
        addressRepository.save(a);
        Address03 a2 = new Address03("925");
        addressRepository.save(a2);

        Address03 a3 = new Address03("1021");
        addressRepository.save(a3);

        User03Address03 ua = new User03Address03(user, a);
        userAddressRepository.save(ua);

        User03Address03 ua2 = new User03Address03(user, a2);
        userAddressRepository.save(ua2);

        User03Address03 ua3 = new User03Address03(user2, a3);
        userAddressRepository.save(ua3);
    }

    @Test
    public void userRepTest() {
        User03 u = userReposityory.find(1);
        log.debug(u.getName());
    }
    @Test
    public void addressRepTest() {
        addressRepository.list("956")
                .forEach(a -> {
                    log.debug("{}", a.getId());
                });
    }

    @Test
    public void userAddressRepTest() {
        User03Address03 ua = userAddressRepository.find("SUN", "1021");
        log.debug("插入时间：{}", ua.getInsertTime());
    }
}

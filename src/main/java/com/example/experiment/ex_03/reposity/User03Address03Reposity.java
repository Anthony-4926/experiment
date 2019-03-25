package com.example.experiment.ex_03.reposity;

import com.example.experiment.ex_03.entity.Address03;
import com.example.experiment.ex_03.entity.User03Address03;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 赵鑫
 * @create 2019-03-25 10:59
 */

@Repository
@Transactional
public interface User03Address03Reposity extends JpaRepository<User03Address03,Integer> {

    @Query("SELECT ud FROM User03Address03 ud WHERE ud.address.detail=:detail AND ud.user.name=:userName")
    User03Address03 find(@Param("userName") String userName,@Param("detail") String detail);
}

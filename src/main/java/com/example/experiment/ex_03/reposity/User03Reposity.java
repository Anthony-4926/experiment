package com.example.experiment.ex_03.reposity;

import com.example.experiment.ex_03.entity.User03;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 赵鑫
 * @create 2019-03-25 10:53
 */

@Repository
@Transactional
public interface User03Reposity extends JpaRepository<User03, Integer> {
    @Query("SELECT u FROM User03 u WHERE u.id=:id")
    User03 find(@Param("id") int id);
}

package com.example.experiment.ex_03.reposity;

import com.example.experiment.ex_03.entity.Address03;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 赵鑫
 * @create 2019-03-25 11:11
 */
@Repository
@Transactional
public interface Address03Reposity extends JpaRepository<Address03, Integer> {
    @Query("SELECT a FROM Address03 a WHERE a.detail=:detail")
    List<Address03> list(@Param("detail") String detail);
}

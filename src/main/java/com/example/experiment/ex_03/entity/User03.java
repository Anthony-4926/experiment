package com.example.experiment.ex_03.entity;

import com.example.experiment.ex_01.entity.User01Address01;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 赵鑫
 * @create 2019-03-25 10:47
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User03 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "user")
    private List<User01Address01> userAddresses;

    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",
            insertable = false, updatable = false)
    private LocalDateTime insertTime;

    public User03(String name) {
        this.name = name;
    }

}

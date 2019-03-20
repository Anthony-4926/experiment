package com.example.experiment.ex_02.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author 赵鑫
 * @create 2019-03-20 9:09
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User02Address02 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Address02 address;

    @ManyToOne
    private User02 user;

    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",
            insertable = false, updatable = false)
    private LocalDateTime insertTime;


    public User02Address02(Address02 address, User02 user) {
        this.address = address;
        this.user = user;
    }
}

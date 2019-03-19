package com.example.experiment.ex_01.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author 赵鑫
 * @create 2019-03-19 17:05
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User01Address01 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Address01 address;

    @ManyToOne
    private User01 user;

    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",
            insertable = false, updatable = false)
    private LocalDateTime insertTime;


    public User01Address01(Address01 address, User01 user) {
        this.address = address;
        this.user = user;
    }
}

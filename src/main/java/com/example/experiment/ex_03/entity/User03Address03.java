package com.example.experiment.ex_03.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author 赵鑫
 * @create 2019-03-25 10:47
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User03Address03 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Address03 address;

    @ManyToOne
    private User03 user;

    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",
            insertable = false, updatable = false)
    private LocalDateTime insertTime;


    public User03Address03(User03 user,Address03 address) {
        this.address = address;
        this.user = user;
    }
}


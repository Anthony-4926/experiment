package com.example.experiment.ex_02.entity;

import com.example.experiment.ex_01.entity.User01Address01;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 赵鑫
 * @create 2019-03-20 19:38
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User02 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<User02Address02> userAddresses;

    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",
            insertable = false, updatable = false)
    private LocalDateTime insertTime;

    public User02(String name) {
        this.name = name;
    }

}

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
public class Address03 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String detail;

    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",
            updatable = false, insertable = false)
    private LocalDateTime insertTime;

    @OneToMany(mappedBy = "address")
    private List<User01Address01> user01Address01s;

    public Address03(String detail) {
        this.detail = detail;
    }

}

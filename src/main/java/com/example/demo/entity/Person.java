package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by HuYanGuang on 2018/1/11.
 * https://www.jianshu.com/p/84f2bbffb885
 *
 * @author HuYanGuang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    private Boolean sex;

    private String address;

    private String phone;

    private String mobile;

    private String email;

    private Boolean deleted;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private IdentityCard identityCard;

    @PrePersist
    public void prePersist() {
        deleted = false;
    }
}

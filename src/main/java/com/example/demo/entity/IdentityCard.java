package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by HuYanGuang on 2018/1/11.
 *
 * @author HuYanGuang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class IdentityCard {

    @Id
    @GeneratedValue
    private Long id;

    private String cardNo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiryDate;

    private Boolean deleted;

    @OneToOne
    @JoinColumn(name = "person_id")
    @RestResource(path = "person", rel = "person")
    private Person person;

    @PrePersist
    public void prePersist() {
        deleted = false;
        if (Objects.isNull(createDate)) {
            createDate = LocalDate.now();
        }
        if (Objects.isNull(expiryDate)) {
            expiryDate = createDate.plusYears(10L).minusDays(1L);
        }
    }
}

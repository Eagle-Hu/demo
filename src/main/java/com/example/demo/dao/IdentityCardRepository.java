package com.example.demo.dao;

import com.example.demo.entity.IdentityCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by HuYanGuang on 2018/1/11.
 *
 * @author HuYanGuang
 */
@RepositoryRestResource(path = "identityCard")
public interface IdentityCardRepository extends JpaRepository<IdentityCard, Long> {
}

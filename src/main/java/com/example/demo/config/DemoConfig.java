package com.example.demo.config;

import com.example.demo.entity.IdentityCard;
import com.example.demo.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Created by HuYanGuang on 2018/1/11.
 *
 * @author HuYanGuang
 */
@Configuration
public class DemoConfig {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return new RepositoryRestConfigurerAdapter() {
            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
                config.exposeIdsFor(Person.class, IdentityCard.class);
            }
        };
    }
}

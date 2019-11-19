package com.lianweibo.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName O2oProductServiceApplication
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/14
 * @Version V1.0
 **/
@SpringBootApplication
@EnableEurekaClient
//@EntityScan("com.lianweibo")
public class O2oProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(O2oProductServiceApplication.class,args);
    }
}

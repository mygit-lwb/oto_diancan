package com.lianweibo.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName OtoEurekaApplication
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/13
 * @Version V1.0
 **/
@EnableEurekaServer
@SpringBootApplication
public class OtoEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(OtoEurekaApplication.class,args);
    }
}

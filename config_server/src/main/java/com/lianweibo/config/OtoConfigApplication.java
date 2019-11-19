package com.lianweibo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassName OtoConfigApplication
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/13
 * @Version V1.0
 **/
@EnableConfigServer
@SpringBootApplication
public class OtoConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(OtoConfigApplication.class,args);
    }
}

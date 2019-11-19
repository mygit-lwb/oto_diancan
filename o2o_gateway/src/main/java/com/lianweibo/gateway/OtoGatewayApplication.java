package com.lianweibo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName OtoGatewayApplication
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/13
 * @Version V1.0
 **/
@EnableEurekaClient
@SpringBootApplication
public class OtoGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(OtoGatewayApplication.class,args);
    }
}

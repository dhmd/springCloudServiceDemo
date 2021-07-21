package com.jiuxiniot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @classname: ClientApplication
 * @description:
 * @author: dhm
 * @create: 2021/07/14 13:51
 */

@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
@RefreshScope   //开启配置更新功能
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

}

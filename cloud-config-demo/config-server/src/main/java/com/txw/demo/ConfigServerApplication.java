package com.txw.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(final String[] args) {
        new SpringApplicationBuilder()
                .sources(ConfigServerApplication.class)
                .run(args);
    }
}
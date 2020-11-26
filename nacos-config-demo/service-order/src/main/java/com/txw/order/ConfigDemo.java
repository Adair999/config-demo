package com.txw.order;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;

import java.util.Properties;
public class ConfigDemo {
    public static void main(String[] args) {
        try {
            String serverAddr = "192.168.64.128:8848";
            String dataId = "service.order.properties";
            String group = "DEFAULT_GROUP";
            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(dataId, group, 5000);
            System.out.println(content);
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
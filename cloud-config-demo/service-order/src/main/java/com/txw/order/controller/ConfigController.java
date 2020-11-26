package com.txw.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RefreshScope
public class ConfigController {
    @Value("${address}")
    String address;
    @RequestMapping(value = "/getConfigInfo", method = RequestMethod.GET)
    public String getConfigInfo() {
        return "address = " + address;
    }
}
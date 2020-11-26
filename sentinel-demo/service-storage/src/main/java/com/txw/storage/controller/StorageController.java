package com.txw.storage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class StorageController {
    @RequestMapping(value = "/storage", method = RequestMethod.GET)
    public String storage() {
        return "storage success";
    }
    @GetMapping("/rt")
    public String rt() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            // ignore
        }
        return "rt：sleep 1s";
    }
    @GetMapping("/flow")
    public String flow() {
        return "flow";
    }
    @GetMapping("/error")
    public String error() {
        throw new RuntimeException("custom");
    }
    @GetMapping("/thread")
    public String thread() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            // ignore
        }
        return "thread";
    }
}
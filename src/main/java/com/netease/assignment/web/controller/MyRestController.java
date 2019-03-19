package com.netease.assignment.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: Tank.Li
 * @date: 2019/3/16 09:27 Saturday
 */
@RestController
public class MyRestController {

    @RequestMapping("/api/v1/test")
    public String test() {
        return "djddjd";
    }
}

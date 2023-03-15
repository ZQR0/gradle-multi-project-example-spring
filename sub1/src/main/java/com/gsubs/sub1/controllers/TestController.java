package com.gsubs.sub1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("test-1")
    public String getTestOne() {
        return "Test 1 passed";
    }

}

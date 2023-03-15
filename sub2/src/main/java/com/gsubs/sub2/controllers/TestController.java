package com.gsubs.sub2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("test-2")
    public String getTestOne() {
        return "Test 2 passed";
    }
}

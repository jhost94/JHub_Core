package com.jhost.core.Core.controller;

import com.jhost.core.Core.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping
    public String test(final Locale locale){
        return testService.getTestMessage(locale);
    }
}

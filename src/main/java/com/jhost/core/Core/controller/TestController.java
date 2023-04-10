package com.jhost.core.Core.controller;

import com.jhost.core.Core.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping
    public String test(final Locale locale){
        return testService.getTestMessage(locale);
    }
}

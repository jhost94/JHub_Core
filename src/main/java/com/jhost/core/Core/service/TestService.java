package com.jhost.core.Core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private MessageSource messageSource;

    public String getTestMessage(){
        return messageSource.getMessage("test.message", null, LocaleContextHolder.getLocale());
    }
}

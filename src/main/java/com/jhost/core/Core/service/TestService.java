package com.jhost.core.Core.service;

import com.jhost.core.Core.config.Constants;
import com.jhost.core.Core.service.meta.MessageService;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class TestService {

    private final MessageService messageService;

    public TestService(MessageService messageService) {
        this.messageService = messageService;
    }

    public String getTestMessage(Locale locale){
        return messageService.getMessage(Constants.MessagePaths.TEST_MESSAGE, locale);
    }
}

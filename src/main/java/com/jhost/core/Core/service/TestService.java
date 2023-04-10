package com.jhost.core.Core.service;

import com.jhost.core.Core.constants.MessagePaths;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class TestService {

    public String getTestMessage(Locale locale){
        return MessagePaths.TEST_MESSAGE.getMessage();
    }
}

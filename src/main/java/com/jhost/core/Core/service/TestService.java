package com.jhost.core.Core.service;

import com.jhost.core.Core.config.Constants;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class TestService {

    public String getTestMessage(Locale locale){
        return Constants.MessagePaths.TEST_MESSAGE.getMessage();
    }
}

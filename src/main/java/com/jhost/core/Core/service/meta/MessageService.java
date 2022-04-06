package com.jhost.core.Core.service.meta;

import com.jhost.core.Core.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(Constants.MessagePaths paths, Locale locale) {
        return messageSource.getMessage(paths.getMessage(), null, locale);
    }
}

package com.jhost.core.Core.config;

import com.jhost.core.Core.service.meta.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class Bootstrap implements CommandLineRunner {

    private final String text;
    private final MessageService messageService;

    public Bootstrap(@Value("${application.text}") String text,
                     MessageService messageService) {
        this.text = text;
        this.messageService = messageService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-------------------------------");
        System.out.println(text);

        Locale localePT = new Locale("pt", "PT");

        System.out.println(messageService.getMessage(Constants.MessagePaths.TEST_MESSAGE, localePT));
        System.out.println(messageService.getMessage(Constants.MessagePaths.TEST_MESSAGE, Locale.US));
    }
}

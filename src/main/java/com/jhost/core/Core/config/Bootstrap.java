package com.jhost.core.Core.config;

import com.jhost.core.Core.service.meta.MessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class Bootstrap implements CommandLineRunner {

    private final MessageService messageService;
    private final ConfigBean configBean;

    public Bootstrap(MessageService messageService,
                     ConfigBean configBean) {
        this.messageService = messageService;
        this.configBean = configBean;
    }

    @Override
    public void run(String... args) throws Exception {
        Locale localePT = new Locale("pt", "PT");

        System.out.println(messageService.getMessage(Constants.MessagePaths.TEST_MESSAGE, localePT));
        System.out.println(messageService.getMessage(Constants.MessagePaths.TEST_MESSAGE, Locale.US));
        System.out.println("Running environment: " + configBean.getEnv().toString());
    }
}

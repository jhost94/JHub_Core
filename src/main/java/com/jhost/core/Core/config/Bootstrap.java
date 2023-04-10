package com.jhost.core.Core.config;

import com.jhost.core.Core.bean.ApplicationEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class Bootstrap implements CommandLineRunner {
    private final ConfigBean configBean;

    @Override
    public void run(String... args) throws Exception {
        logEnv();
    }

    private void logEnv() {
        log.info(ApplicationEnvironment.isBuilding(configBean.getEnv()) ?
                "Building project." :
                "Running environment: " + configBean.getEnv().toString());
    }
}

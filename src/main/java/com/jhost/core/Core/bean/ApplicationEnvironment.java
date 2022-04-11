package com.jhost.core.Core.bean;

public enum ApplicationEnvironment {
    NONE,
    BUILD,
    DEV,
    QA,
    PRE_RELEASE,
    PROD;

    public static ApplicationEnvironment fromString(String env) {
        switch (env) {
            case "dev":
                return ApplicationEnvironment.DEV;
            case "qa":
                return ApplicationEnvironment.QA;
            case "pre-release":
                return ApplicationEnvironment.PRE_RELEASE;
            case "prod":
                return ApplicationEnvironment.PROD;
            case "build":
                return ApplicationEnvironment.BUILD;
            default:
                return ApplicationEnvironment.NONE;
        }
    }
}

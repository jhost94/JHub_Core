package com.jhost.core.Core.constants;

import java.util.Base64;

public abstract class Security {
    private static final String SECRET = "key";

    public static final int SECOND_IN_MILLISECONDS = 1000;
    public static final int MINUTE_IN_MILLISECONDS = SECOND_IN_MILLISECONDS * 60;
    public static final int HOUR_IN_MILLISECONDS = MINUTE_IN_MILLISECONDS * 60;
    public static final int DAY_IN_MILLISECONDS = HOUR_IN_MILLISECONDS * 24;
    public static final long WEEK_IN_MILLISECONDS = DAY_IN_MILLISECONDS * 7L;
    public static final long MONTH_IN_MILLISECONDS = DAY_IN_MILLISECONDS * 30L;
    public static final long YEAR_IN_MILLISECONDS = DAY_IN_MILLISECONDS * 365L;

    public static final int EXPIRATION_TIME = HOUR_IN_MILLISECONDS * 2;
    public static final String AUTHORITIES = "authorities";
    public static final String NAME = "name";
    public static final String SECRET_KEY = Base64.getEncoder().encodeToString(SECRET.getBytes());
}

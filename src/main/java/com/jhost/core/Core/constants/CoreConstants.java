package com.jhost.core.Core.constants;

import java.util.Base64;

public abstract class CoreConstants {
    static public class JWTToken {
        public static final String HEADER = "core_token";
        public static final String PREFIX = "Bearer ";
        public static final String ROLE = "User";
    }

    static public class Security {
        private static final String SECRET = "key";

        public static final int EXPIRATION_TIME = 1000 * 60 * 60; //1 hour
        public static final String AUTHORITIES = "authorities";
        public static final String NAME = "name";
        public static final String SECRET_KEY = Base64.getEncoder().encodeToString(SECRET.getBytes());
    }
}

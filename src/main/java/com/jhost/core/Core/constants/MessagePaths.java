package com.jhost.core.Core.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessagePaths {
    TEST_MESSAGE("test.message");

    private final String message;
}

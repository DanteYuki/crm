package com.xykj.base.util;

import java.util.UUID;

public class UuidUtil {
    public UuidUtil() {
    }

    public static String get32UUID() {
        String uuid = uuid().toString().trim().replaceAll("-", "");
        return uuid;
    }

    private static String uuid() {
        return UUID.randomUUID().toString();
    }
}
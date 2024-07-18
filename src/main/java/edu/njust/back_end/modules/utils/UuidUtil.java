package edu.njust.back_end.modules.utils;

import java.util.UUID;

public class UuidUtil {
    public static String randomUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }
}

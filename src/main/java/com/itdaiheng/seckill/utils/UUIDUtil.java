package com.itdaiheng.seckill.utils;

import java.util.UUID;

/**
 *
 * @author itdaiheng
 */
public class UUIDUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
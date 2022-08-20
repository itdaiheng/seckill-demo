package com.itdaiheng.seckill.utils;

import org.thymeleaf.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author：itdaiheng
 * @data:2022/8/8-18:00
 * @Description:
 */
public class ValidatorUtil {
    private static final Pattern mobile_patten = Pattern.compile("[1]([3-9])[0-9]{9}$");

    /**
     * 检测手机号
     * @param mobile
     * @return
     */
    public static boolean isMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return false;
        }
        Matcher matcher = mobile_patten.matcher(mobile);
        return matcher.matches();
    }
}


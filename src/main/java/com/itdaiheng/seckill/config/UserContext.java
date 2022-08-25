package com.itdaiheng.seckill.config;

import com.itdaiheng.seckill.pojo.User;

/**
 * @Description:
 * @Author itdaiheng
 * @Date 2022/8/25 20:05
 */

public class UserContext {

    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static void setUser(User user) {
        userThreadLocal.set(user);
    }

    public static User getUser() {
        return userThreadLocal.get();
    }
}

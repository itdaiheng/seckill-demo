package com.itdaiheng.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:启动类
 * @Author itdaiheng
 * @Date 2022/8/16 14:08
 */


@SpringBootApplication
@MapperScan("com.itdaiheng.seckill.mapper")
public class SeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class, args);
    }

}

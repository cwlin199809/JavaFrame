package com.cwlin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringBoot09RedisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        /* redisTemplate 操作不同的数据类型，API 和 Redis 中的是一样的
         * opsForValue 类似于 Redis 中的 String
         * opsForList 类似于 Redis 中的 List
         * opsForSet 类似于 Redis 中的 Set
         * opsForHash 类似于 Redis 中的 Hash
         * opsForZSet 类似于 Redis 中的 ZSet
         * opsForGeo 类似于 Redis 中的 Geospatial
         * opsForHyperLogLog 类似于 Redis 中的 HyperLogLog
         */

        //除了基本的操作，常用的命令都可以直接通过redisTemplate操作，比如事务和CURD。和数据库相关的操作都需要通过连接操作

        /* 获取连接对象
         * RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
         * connection.flushDb();
         * connection.flushAll();
         */

        redisTemplate.opsForValue().set("myKey", "cwlin");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }
}

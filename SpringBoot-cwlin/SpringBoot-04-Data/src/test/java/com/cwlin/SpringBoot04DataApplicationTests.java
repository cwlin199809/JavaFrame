package com.cwlin;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringBoot04DataApplicationTests {
    //SpringBoot只要配置了数据源，就自动将数据源封装进IOC容器，用户无需配置数据源组件，直接取出
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        //查看默认数据源
        System.out.println(dataSource.getClass());
        //获得数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //测试Druid数据源
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        //关闭数据库连接
        connection.close();
    }

}

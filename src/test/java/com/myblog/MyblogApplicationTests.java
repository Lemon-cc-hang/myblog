package com.myblog;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class MyblogApplicationTests {

    @Autowired
    DataSource dataSource;

    // 测试数据库配置和druid连接配置
    @Test
    void contextLoads() throws SQLException {
        // 查看一下驱动类
        System.out.println(dataSource.getClass());
        System.out.println("==========");

        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        DruidDataSource druidDataSource = (DruidDataSource) this.dataSource;

        System.out.println("最大连接数为：" + druidDataSource.getMaxActive());

        System.out.println("数据源初始化连接数：" + druidDataSource.getInitialSize());

        // 归还连接
        connection.close();
    }

    @Test
    void testQuery() {
        
    }
}

package org.fenrir.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"org.fenrir.mybatis.infra.mysql"})
public class MybatisDemoApplication {




    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

}

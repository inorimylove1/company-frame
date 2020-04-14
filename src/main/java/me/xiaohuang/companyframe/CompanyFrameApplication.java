package me.xiaohuang.companyframe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("me.xiaohuang.companyframe.mapper")
public class CompanyFrameApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyFrameApplication.class, args);
    }

}

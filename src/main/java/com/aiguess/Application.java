package com.aiguess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *  核心启动
 * @author kelen
 * @date 2018年4月12日 下午2:57:28
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

//@SpringBootApplication
//@MapperScan("com.aiguess.realtimePriceService.entity")

//允许事务
@EnableTransactionManagement

@EnableScheduling
@EnableCaching
public class Application  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

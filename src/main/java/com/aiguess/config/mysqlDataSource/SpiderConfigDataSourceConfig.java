package com.aiguess.config.mysqlDataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 爬虫配置的数据库
 */
@Component
//@PropertySource({"classpath:application.yml"})
@MapperScan(basePackages = SpiderConfigDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "spiderConfigSqlSessionFactory")
public class SpiderConfigDataSourceConfig {
    static final String PACKAGE = "com.aiguess.realtimePriceService.IDao.spiderConfigDao";  //扫描的mapper包结构

    @Value("${spiderConfig.datasource.url}") //配置文件中的配置
    private String dbUrl;
    @Value("${spiderConfig.datasource.username}") //配置文件中的配置
    private String dbUser;
    @Value("${spiderConfig.datasource.password}") //配置文件中的配置
    private String dbPassword;
    
    @Autowired  
    private Environment env;  

    @Bean(name = "spiderConfigDataSource")
    @Primary   //此注解表示在默认的数据源配置，即在默认配置时用到的数据源配置
    public DataSource spiderConfigDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);

        //add 09-06
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(30);

        return dataSource;
    }
    

    @Bean(name = "spiderConfigTransactionManager")
    @Primary
    public DataSourceTransactionManager spiderConfigTransactionManager(@Qualifier("spiderConfigDataSource") DataSource adsDataSource) {
        return new DataSourceTransactionManager(adsDataSource);
    }

    @Bean(name = "spiderConfigSqlSessionFactory")
    @Primary
    public SqlSessionFactory spiderConfigSqlSessionFactory(@Qualifier("spiderConfigDataSource") DataSource adsDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(adsDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sessionFactory.getObject();
    }
}
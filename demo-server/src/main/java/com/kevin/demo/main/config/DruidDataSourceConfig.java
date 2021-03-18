package com.kevin.demo.main.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.geekplus.optimus.data.datasource.DataSourceTypeEnum;
import com.geekplus.optimus.data.datasource.DynamicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(basePackages = {"com.kevin.demo.repository"})
public class DruidDataSourceConfig {

    @Bean(name = "master")
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource master() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "slave")
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
    public DataSource slave() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 动态数据源配置
     */
    @Bean(name = "dynamicDataSource")
    @Primary
    public javax.sql.DataSource dynamicDataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceTypeEnum.MASTER, master());
        targetDataSources.put(DataSourceTypeEnum.SLAVE, slave());

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //添加数据源
        dynamicDataSource.setTargetDataSources(targetDataSources);
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(targetDataSources.get(DataSourceTypeEnum.MASTER));
        return dynamicDataSource;
    }

    @Bean
    public DataSource dataSource() throws IOException {
        return new LazyConnectionDataSourceProxy(dynamicDataSource());
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) throws IOException {
        return builder
                .dataSource(dataSource())
                .packages("com.kevin.demo")
                .build();
    }

    @Bean(name = "transactionManager")
    JpaTransactionManager transactionManager(EntityManagerFactoryBuilder builder) throws IOException {
        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    }
}

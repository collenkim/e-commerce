package com.collenkim.ecommerce.config;

import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(basePackages = {
    "com.collenkim.ecommerce.member.repository",
    "com.collenkim.ecommerce.payment.repository",
    "com.collenkim.ecommerce.product.repository",
    "com.collenkim.ecommerce.order.repository"
})
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setJdbcUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setAutoCommit(false);
        dataSource.setMinimumIdle(2);
        dataSource.setMaximumPoolSize(5);
        dataSource.setPoolName("ecommerce-hikari-pool");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(
            "com.collenkim.ecommerce.customer.domain",
            "com.collenkim.ecommerce.payment.domain",
            "com.collenkim.ecommerce.product.domain",
            "com.collenkim.ecommerce.order.domain",
            "com.collenkim.ecommerce.member.domain");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);  // 스키마 자동 생성
        vendorAdapter.setShowSql(true);  // SQL 쿼리 로깅
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(jpaProperties());
        return em;
    }

    private Properties jpaProperties() {

        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create");  // 테이블 자동 업데이트
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.show_sql", "true");  // SQL 로그 출력
        properties.setProperty("hibernate.format_sql", "true");  // SQL 포맷팅
        return properties;
    }

}

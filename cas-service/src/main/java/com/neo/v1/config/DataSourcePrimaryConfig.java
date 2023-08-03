package com.neo.v1.config;

import com.neo.core.builder.DatabasePoolConfigBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static com.neo.v1.constant.CasConstant.CORE_REPOSITORY_PACKAGE;
import static com.neo.v1.constant.CasConstant.POSTGRES_DB_PERSISTENCE_UNIT;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager", basePackages = { CORE_REPOSITORY_PACKAGE })
public class DataSourcePrimaryConfig {

    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource(DormancyPrimaryPoolConfig poolConfig, DatabasePoolConfigBuilder databasePoolConfigBuilder) {
        return databasePoolConfigBuilder.build(poolConfig);
    }

    @Bean(name = "replicaDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.replica")
    public DataSource replicaDataSource(DormancyPrimaryPoolConfig poolConfig, DatabasePoolConfigBuilder databasePoolConfigBuilder) {
        return databasePoolConfigBuilder.build(poolConfig);
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("routingDatasource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.neo.v1.entity")
                .persistenceUnit(POSTGRES_DB_PERSISTENCE_UNIT)
                .properties(getJPAProperties())
                .build();
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    @Primary
    public DataSource routingDatasource(@Qualifier("primaryDataSource") DataSource primaryDataSource,
                                        @Qualifier("replicaDataSource") DataSource replicaDataSource) {
        final RoutingDataSource dataSource = new RoutingDataSource();

        final Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(RoutingDataSource.Route.PRIMARY, primaryDataSource);
        targetDataSources.put(RoutingDataSource.Route.REPLICA, replicaDataSource);

        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(primaryDataSource);

        return dataSource;
    }

    private Map<String, String> getJPAProperties() {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return properties;
    }
}

package com.comparus.primary.migration;

import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PrimaryDatabaseMigration {

    @Autowired
    @Qualifier("primaryDbDataSource")
    private DataSource primaryDatasource;

    @Value("${spring.flyway.primary.locations}")
    private String primaryLocations;

    @PostConstruct
    public void migratePrimaryDatabase() {
        Flyway.configure()
                .dataSource(primaryDatasource)
                .locations(primaryLocations)
                .load()
                .migrate();
    }

}

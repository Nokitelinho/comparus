package com.comparus.common.migration;

import com.comparus.common.configuration.ConfigProperties;
import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrimaryDatabaseMigration {

    private final ConfigProperties configProperties;

    public PrimaryDatabaseMigration(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @PostConstruct
    public void migratePrimaryDatabase() {

        var datasourceList = configProperties.getDatasource();

        datasourceList.forEach(ds->{
            var dataSource = DataSourceBuilder.create()
                    .url(ds.getUrl())
                    .username(ds.getUsername())
                    .password(ds.getPassword())
                    .build();

            Flyway.configure()
                    .dataSource(dataSource)
                    .locations(ds.getMigration())
                    .load()
                    .migrate();
        });
    }

}
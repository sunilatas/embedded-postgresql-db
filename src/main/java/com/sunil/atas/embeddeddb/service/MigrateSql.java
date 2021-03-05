package com.sunil.atas.embeddeddb.service;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Service
public class MigrateSql {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void migrateWithFlyway() {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("db/migration")
                .load();
        flyway.migrate();
    }
}

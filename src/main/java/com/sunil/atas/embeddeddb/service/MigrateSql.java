package com.sunil.atas.embeddeddb.service;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Service
public class DBMigrationService {

    @Autowired
    private PGSimpleDataSource inMemoryDataSource;

    @Value("${spring.flyway.dbMigrationPath}")
    private String dbMigrationPath;

    @PostConstruct
    public void migrateWithFlyway() {
        Flyway flyway = Flyway.configure()
                .dataSource(inMemoryDataSource)
                .locations(dbMigrationPath)
                .load();
        flyway.migrate();
        
        log.info("************************************************");
        log.info("URL : {}", inMemoryDataSource.getURL());
        log.info("SERVER : {}", inMemoryDataSource.getServerNames()[0]);
        log.info("PORT : {}", inMemoryDataSource.getPortNumbers()[0]);
        log.info("DB NAME : {}", inMemoryDataSource.getDatabaseName());
        log.info("USER : {}", inMemoryDataSource.getUser());
        log.info("PASSWORD : {}", inMemoryDataSource.getPassword());
        log.info("************************************************");
    }
}

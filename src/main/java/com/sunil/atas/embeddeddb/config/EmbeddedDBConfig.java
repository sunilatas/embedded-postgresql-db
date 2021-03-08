package com.sunil.atas.embeddeddb.config;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class EmbeddedDBConfig {

    @Bean
    public PGSimpleDataSource inMemoryDS() throws Exception {
        return (PGSimpleDataSource) EmbeddedPostgres.builder().start().getPostgresDatabase();
    }
}

package com.sunil.atas.embeddeddb.config;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class EmbeddedDBConfig {

    @Bean
    public DataSource inMemoryDS() throws Exception {
        DataSource embeddedPostgresDS = EmbeddedPostgres.builder().start().getPostgresDatabase();
        return embeddedPostgresDS;
    }
}
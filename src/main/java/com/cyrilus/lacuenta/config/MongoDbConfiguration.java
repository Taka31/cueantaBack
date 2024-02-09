package com.cyrilus.lacuenta.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.cyrilus.lacuenta.repository")
public class MongoDbConfiguration {

    @Value("${dbport}")
    private String port;

    @Value("${dbname}")
    private String dbName;

    public MongoClient reactiveMongoClient(){
        return MongoClients.create();
    }

    protected String getDataBaseName(){
        return dbName;
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate(){
        return new ReactiveMongoTemplate(reactiveMongoClient(),getDataBaseName());
    }

}

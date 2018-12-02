package com.maciejkry.redlit.redlits;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoConfig {
    @Value("${spring.data.mongodb.uri:mongodb://localhost:27017}")
    private String mongoUri;

    private MongoClient createMongo() {
        return new MongoClient(new MongoClientURI(mongoUri));
    }

    @Primary
    @Bean
    public Mongo readFromSecondaryMongo() {
        final Mongo mongo = createMongo();
        // Do custom global configuration
        mongo.setReadPreference(ReadPreference.secondary());
        return mongo;
    }

    @Bean
    public Mongo readFromPrimaryMongo() {
        final Mongo mongo = createMongo();
        mongo.setReadPreference(ReadPreference.primaryPreferred());
        return mongo;
    }

    @Bean
    public MongoDbFactory mongoDbFactory(MongoClient mongo) {
        return new SimpleMongoDbFactory(mongo, "springgeo");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(createMongo(), "test");
    }
}

package com.maciejkry.redlit.redlits;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface RedlitsRepository extends MongoRepository<Comment, String> {
}

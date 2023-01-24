package com.volacode.URLShortener.data.repositories;

import com.volacode.URLShortener.data.models.URLLink;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface URLRepository extends MongoRepository<Long, URLLink> {

    URLLink findURLLinkById(String id);

}

package com.api.users.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.api.users.entities.User;


@Service
public class UserService {

    private MongoTemplate mongoTemplate;

    public UserService (MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<User> findAll(Pageable pageable, User user) {
        Query query = new Query();
        query.addCriteria(createCriteria(user));
        query.with(pageable.getSort());
        query.with(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
        return mongoTemplate.find(query, User.class);
    }

    public Criteria createCriteria(User user) {
        Criteria criteria = new Criteria();
        
        if (user.getName() != null && !user.getName().isEmpty())
            criteria.andOperator(Criteria.where("name").regex(".*" + user.getName() + ".*"));

        return criteria;
    }
}

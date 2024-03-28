package com.api.users.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.api.users.entities.User;
import com.querydsl.core.types.Predicate;

import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<User, String>, QuerydslPredicateExecutor<User> {

    Page<User> findAll(Predicate predicate, Pageable pageable);
    
    Optional<User> findByUserId(Integer userId);
    
}
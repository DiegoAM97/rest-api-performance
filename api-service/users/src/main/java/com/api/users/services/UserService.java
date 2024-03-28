package com.api.users.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.users.entities.QUser;
import com.api.users.entities.User;
import com.api.users.repositories.UserRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;


@Service
public class UserService {

    private UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> findAll(User user, Pageable pageable) {
        Predicate predicate = createPredicate(user);
        return this.userRepository.findAll(predicate, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort())) ;
    }

    public Optional<User> findByUserId(Integer id) {
        return this.userRepository.findByUserId(id);
    }

    private Predicate createPredicate(User user) {

        QUser qUser = new QUser("user");
        Predicate predicate = new BooleanBuilder();

        if (user.getName() != null && !user.getName().isEmpty())
            predicate = qUser.name.contains(user.getName()).and(predicate);
        if (user.getSurname() != null && !user.getSurname().isEmpty())
            predicate = qUser.surname.contains(user.getSurname()).and(predicate);
        if (user.getUsername() != null && !user.getUsername().isEmpty())
            predicate = qUser.username.contains(user.getUsername()).and(predicate);
        if (user.getEmail() != null && !user.getEmail().isEmpty())
            predicate = qUser.email.contains(user.getEmail()).and(predicate);
        if (user.getIsAdmin() != null)
            predicate = qUser.isAdmin.eq(user.getIsAdmin()).and(predicate);
        if (user.getTechSkills() != null) {
            if (user.getTechSkills().isEmpty())
                predicate = qUser.techSkills.size().eq(0).and(predicate);
            else
                predicate = qUser.techSkills.any().in(user.getTechSkills()).and(predicate);
        }

        return predicate;
    } 


    // Another way
    /*

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

    */
}
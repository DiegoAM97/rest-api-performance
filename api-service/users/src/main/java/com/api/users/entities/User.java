package com.api.users.entities;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@QueryEntity
public class User {

    @Id
    private String objectId;
    private Integer userId;
    private String name;
    private String surname;
    private String username;
    private String email;
    private Boolean isAdmin;
    private List<String> techSkills;
}

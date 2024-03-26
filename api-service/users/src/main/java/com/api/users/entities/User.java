package com.api.users.entities;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String objectId;
    private Integer userId;
    private String name;
    private String surname;
    private String username;
    private String email;
    private boolean isAdmin;
    private List<String> techSkills;
}

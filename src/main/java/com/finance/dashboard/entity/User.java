package com.finance.dashboard.entity;

import com.finance.dashboard.entity.enums.Role;
import com.finance.dashboard.entity.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;
}
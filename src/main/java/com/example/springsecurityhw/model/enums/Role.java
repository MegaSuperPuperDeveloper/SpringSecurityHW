package com.example.springsecurityhw.model.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

//@Entity
//@Table(name = "roles")
@Getter
public enum Role {

    ROLE_ADMIN("admin"), ROLE_USER("user");

    private final String value;

    Role(String value) {
        this.value = value;
    }
}
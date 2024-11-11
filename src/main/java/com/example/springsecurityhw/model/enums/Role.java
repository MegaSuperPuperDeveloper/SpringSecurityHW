package com.example.springsecurityhw.model.enums;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
public enum Role {

    ROLE_ADMIN("admin"), ROLE_USER("user");

    private final String name;

    Role(String value) {
        this.name = value;
    }
}
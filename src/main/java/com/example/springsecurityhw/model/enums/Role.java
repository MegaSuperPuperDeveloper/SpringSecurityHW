package com.example.springsecurityhw.model.enums;

import lombok.Getter;

@Getter
public enum Role {

    ROLE_ADMIN("admin"), ROLE_USER("user");

    private final String value;

    Role(String value) {
        this.value = value;
    }
}
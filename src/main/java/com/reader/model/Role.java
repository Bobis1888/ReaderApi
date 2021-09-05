package com.reader.model;

public enum Role {
    USER("user"),ADMIN("admin"),ROOT_USER("root_user");

    String name;

    Role(String name) {
        this.name = name;
    }
}

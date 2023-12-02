package com.example.demo.minio.enumrate;

import lombok.Getter;

@Getter
public enum MediaType {
    IMAGE("images"),
    VIDEO("videos"),
    FILE("files"),
    ;
    private final String path;

    MediaType(String path) {
        this.path = path;
    }
}
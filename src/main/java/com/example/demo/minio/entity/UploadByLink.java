package com.example.demo.minio.entity;


import com.example.demo.minio.enumrate.MediaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class UploadByLink {

    @NotNull
    private String link;

    @NotNull
    @Builder.Default
    private MediaType type = MediaType.FILE;
}
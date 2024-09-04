package com.example.emazonstock.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CategoryRequest {

    @NotBlank(message = "Name is mandatory")
    @NotNull(message = "Name is mandatory")
    @Size(max = 50, message = "Name max length is 50")
    private String name;

    @NotBlank(message = "Description is mandatory")
    @NotNull(message = "Description is mandatory")
    @Size(max = 90, message = "Description max length is 90")
    private String description;

}
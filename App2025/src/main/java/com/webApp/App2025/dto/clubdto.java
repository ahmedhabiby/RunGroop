package com.webApp.App2025.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class clubdto {
    private long id;
    @NotEmpty(message = "the title must not be empty")
    private String title;
    @NotEmpty(message = "the content must not be empty")
    private String content;
    @NotEmpty(message = "the photo url must not be empty")
    private String photoUrl;
    private LocalDateTime createdon;
    private LocalDateTime updatedon;
}

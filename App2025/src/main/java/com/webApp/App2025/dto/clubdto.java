package com.webApp.App2025.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class clubdto {
    private long id;
    private String title;
    private String content;
    private String photoUrl;
    private LocalDateTime createdon;
    private LocalDateTime updatedon;
}

package com.webApp.App2025.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clubs")
public class club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "the title must not be empty")
    private String title;
    @NotEmpty(message = "the content must not be empty")
    private String content;
    @NotEmpty(message = "the photo url must not be empty")
    private String photoUrl;
    @CreationTimestamp
    private LocalDateTime createdon;
    @UpdateTimestamp
    private LocalDateTime updatedon;
}


package com.maina.redditBackend.model;

import kotlin.Lazy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

import static javax.persistence.FetchType.LAZY;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Subreddit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Community name is required")
    private String name;
    @NotBlank(message = "Description Required")
    private String description;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Post> posts;
    @ManyToOne(fetch = LAZY)
    private User user;
}

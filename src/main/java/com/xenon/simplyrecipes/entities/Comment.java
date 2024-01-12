package com.xenon.simplyrecipes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "comments")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String text;

    @Getter
    @Setter
    private LocalDateTime datePosted;

    /*TODO: THINK ABOUT THIS*/

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    @JsonIgnore
    @Getter
    @Setter
    private Recipe recipe;

}

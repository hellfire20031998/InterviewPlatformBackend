package com.hellFire.real_time.video.player.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue
    private Long id;

    private Long questionId;
    private String userId;
    private String response;
}


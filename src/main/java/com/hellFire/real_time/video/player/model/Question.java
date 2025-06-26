package com.hellFire.real_time.video.player.model;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Entity
@Data
    public class Question {
        @Id
        @GeneratedValue
        private Long id;

        private String questionText;
        private String type; // "MCQ", "TEXT", "CHECKBOX"

        @ElementCollection
        private List<String> options;

        private String createdBy; // username or ID
    }



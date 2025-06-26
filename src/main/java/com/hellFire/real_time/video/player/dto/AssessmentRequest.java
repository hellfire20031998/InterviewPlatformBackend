package com.hellFire.real_time.video.player.dto;

import lombok.Data;

import java.util.List;

@Data
public class AssessmentRequest {
    private String name;
    private String language;
    private List<String> techStack;
    private String suggestions;
}

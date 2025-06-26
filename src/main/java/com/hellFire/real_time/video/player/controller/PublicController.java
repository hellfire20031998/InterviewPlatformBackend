package com.hellFire.real_time.video.player.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/info")
    public String getPublicInfo() {

        return "This is public information accessible to everyone.";
    }
}

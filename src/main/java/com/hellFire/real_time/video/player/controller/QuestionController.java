package com.hellFire.real_time.video.player.controller;

import com.hellFire.real_time.video.player.model.Answer;
import com.hellFire.real_time.video.player.model.Question;
import com.hellFire.real_time.video.player.repo.AnswerRepository;
import com.hellFire.real_time.video.player.repo.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {

    @Autowired
    private final QuestionRepository questionRepo;
    @Autowired
    private final AnswerRepository answerRepo;

//    @PreAuthorize("hasRole('INTERVIEWER')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Question q, @AuthenticationPrincipal Jwt jwt) {
        q.setCreatedBy(jwt.getSubject());
        return ResponseEntity.ok(questionRepo.save(q));
    }

//    @PreAuthorize("hasRole('CANDIDATE')")
    @GetMapping("/all")
    public List<Question> getAll() {
        return questionRepo.findAll();
    }

//    @PreAuthorize("hasRole('CANDIDATE')")
    @PostMapping("/submit")
    public ResponseEntity<?> submitAnswers(@RequestBody List<Answer> answers, @AuthenticationPrincipal Jwt jwt) {
        answers.forEach(a -> a.setUserId(jwt.getSubject()));
        answerRepo.saveAll(answers);
        return ResponseEntity.ok("Submitted");
    }
}


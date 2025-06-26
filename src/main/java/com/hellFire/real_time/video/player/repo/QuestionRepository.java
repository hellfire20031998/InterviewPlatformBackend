package com.hellFire.real_time.video.player.repo;

import com.hellFire.real_time.video.player.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    // Custom query methods can be added here if needed
    // For example, to find questions by type:
    List<Question> findByType(String type);

    // Or to find questions created by a specific user
    List<Question> findByCreatedBy(String createdBy);
}

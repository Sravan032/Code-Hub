package com.sravan.Coding_Platform.repository;

import com.sravan.Coding_Platform.model.Submission;
import com.sravan.Coding_Platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission,Long> {
    List<Submission> findByUser(User user);
    List<Submission> findByUserAndStatus(User user, String status);
    long countByUserAndStatus(User user,String status);
}

package com.sravan.Coding_Platform.repository;

import com.sravan.Coding_Platform.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem,Long> {
}

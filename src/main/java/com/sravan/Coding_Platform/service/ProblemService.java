package com.sravan.Coding_Platform.service;

import com.sravan.Coding_Platform.dto.ProblemRequest;
import com.sravan.Coding_Platform.model.Problem;
import com.sravan.Coding_Platform.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProblemService {
    @Autowired
    private ProblemRepository problemRepository;

    public Problem createProblem(ProblemRequest request){
        Problem problem = new Problem();

        problem.setTitle(request.getTitle());
        problem.setDescription(request.getDescription());
        problem.setDifficulty(request.getDifficulty());

        return problemRepository.save(problem);
    }

    public List<Problem> getAllProblems(){
        return problemRepository.findAll();
    }

    public Problem getById(Long id){
        Optional<Problem> optionalProblem = problemRepository.findById(id);
        if(optionalProblem.isEmpty()) {
            throw new RuntimeException("Problem not found");
        }
        return optionalProblem.get();
    }
}


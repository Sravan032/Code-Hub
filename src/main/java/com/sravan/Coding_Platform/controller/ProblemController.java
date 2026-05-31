package com.sravan.Coding_Platform.controller;

import com.sravan.Coding_Platform.dto.ProblemRequest;
import com.sravan.Coding_Platform.model.Problem;
import com.sravan.Coding_Platform.service.ProblemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/problems")
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Problem createProblem(@Valid @RequestBody ProblemRequest request){
        return problemService.createProblem(request);
    }

    @GetMapping
    public List<Problem> getAllProblems(){
        return problemService.getAllProblems();
    }

    @GetMapping("/{id}")
    public Problem getById(@PathVariable Long id){
        return problemService.getById(id);
    }
}

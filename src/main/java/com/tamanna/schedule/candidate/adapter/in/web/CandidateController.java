package com.tamanna.schedule.candidate.adapter.in.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tamanna.schedule.candidate.application.port.in.CreateCandidateCommand;
import com.tamanna.schedule.candidate.application.port.in.CreateCandidateUseCase;
import com.tamanna.schedule.candidate.application.port.in.GetCandidateQuery;
import com.tamanna.schedule.candidate.application.port.in.RemoveCandidateUseCase;
import com.tamanna.schedule.candidate.domain.Candidate;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/candidates")
@RequiredArgsConstructor
class CandidateController {

    private final GetCandidateQuery getCandidateQuery;
    private final CreateCandidateUseCase createCandidateUseCase;
    private final RemoveCandidateUseCase removeCandidateUseCase;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Candidate> getCandidates() {
        return getCandidateQuery.getCandidates();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") Long id) {
        Candidate candidate = getCandidateQuery.getById(id);
        return new ResponseEntity<>(candidate, HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Candidate> addCandidate(@Validated @RequestBody CreateCandidateCommand command) {
        Candidate candidate = createCandidateUseCase.addCandidate(command);
        return new ResponseEntity<>(candidate, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCandidate(@PathVariable(value = "id") Long id) {
        removeCandidateUseCase.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

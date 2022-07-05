package com.tamanna.schedule.candidate.application.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tamanna.schedule.candidate.application.port.in.CreateCandidateCommand;
import com.tamanna.schedule.candidate.application.port.in.CreateCandidateUseCase;
import com.tamanna.schedule.candidate.application.port.in.GetCandidateQuery;
import com.tamanna.schedule.candidate.application.port.in.RemoveCandidateUseCase;
import com.tamanna.schedule.candidate.application.port.out.CreateCandidatePort;
import com.tamanna.schedule.candidate.application.port.out.LoadCandidatePort;
import com.tamanna.schedule.candidate.application.port.out.RemoveCandidatePort;
import com.tamanna.schedule.candidate.domain.Candidate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class CandidateService
    implements GetCandidateQuery, CreateCandidateUseCase, RemoveCandidateUseCase {

    private final LoadCandidatePort loadCandidatePort;
    private final CreateCandidatePort createCandidatePort;
    private final RemoveCandidatePort removeCandidatePort;

    @Override
    public List<Candidate> getCandidates() {
        return loadCandidatePort.getCandidates();
    }

    @Override
    public Candidate getById(Long id) {
        return loadCandidatePort.getById(id);
    }

    @Override
    public Candidate addCandidate(CreateCandidateCommand candidateCommand) {
        Candidate Candidate = new Candidate(candidateCommand.getName(), candidateCommand.getAvailabilityList());
        return createCandidatePort.addCandidate(Candidate);
    }

    @Override
    public void deleteCandidate(Long id) {
        removeCandidatePort.removeById(id);
    }

}

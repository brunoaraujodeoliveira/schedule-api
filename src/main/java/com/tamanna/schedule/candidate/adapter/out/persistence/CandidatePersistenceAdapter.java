package com.tamanna.schedule.candidate.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.tamanna.schedule.candidate.application.port.out.CreateCandidatePort;
import com.tamanna.schedule.candidate.application.port.out.LoadCandidatePort;
import com.tamanna.schedule.candidate.application.port.out.RemoveCandidatePort;
import com.tamanna.schedule.candidate.domain.Candidate;
import com.tamanna.schedule.common.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
class CandidatePersistenceAdapter implements LoadCandidatePort, CreateCandidatePort, RemoveCandidatePort {

    private final CandidateRepository candidateRepository;

    @Override
    public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate getById(Long id) {
        return candidateRepository.getReferenceById(id);
    }

    @Override
    public Candidate addCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public void removeById(Long id) {
        Candidate candidate = Optional.of(getById(id))
            .orElseThrow(() -> new NotFoundException("Candidate not found"));

        candidateRepository.delete(candidate);
    }
}

package com.tamanna.schedule.candidate.application.port.out;

import java.util.List;

import com.tamanna.schedule.candidate.domain.Candidate;

public interface LoadCandidatePort {

    List<Candidate> getCandidates();

    Candidate getById(Long id);

}

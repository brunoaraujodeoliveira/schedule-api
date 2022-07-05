package com.tamanna.schedule.candidate.application.port.out;

import com.tamanna.schedule.candidate.domain.Candidate;

public interface CreateCandidatePort {

    Candidate addCandidate(Candidate candidate);

}

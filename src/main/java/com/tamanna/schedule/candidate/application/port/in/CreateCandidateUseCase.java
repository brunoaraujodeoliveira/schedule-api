package com.tamanna.schedule.candidate.application.port.in;

import com.tamanna.schedule.candidate.domain.Candidate;

public interface CreateCandidateUseCase {

	Candidate addCandidate(CreateCandidateCommand createCandidateCommand);

}

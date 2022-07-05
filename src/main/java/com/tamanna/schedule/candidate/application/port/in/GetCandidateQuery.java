package com.tamanna.schedule.candidate.application.port.in;

import java.util.List;

import com.tamanna.schedule.candidate.domain.Candidate;

public interface GetCandidateQuery {

	List<Candidate> getCandidates();

	Candidate getById(Long id);

}

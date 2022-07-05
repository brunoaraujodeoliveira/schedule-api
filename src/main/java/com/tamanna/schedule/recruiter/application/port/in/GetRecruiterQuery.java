package com.tamanna.schedule.recruiter.application.port.in;

import java.util.List;

import com.tamanna.schedule.recruiter.domain.Recruiter;

public interface GetRecruiterQuery {

	List<Recruiter> getRecruiters();

	Recruiter getById(Long id);

}

package com.tamanna.schedule.recruiter.application.port.in;

import com.tamanna.schedule.recruiter.domain.Recruiter;

public interface CreateRecruiterUseCase {

	Recruiter addRecruiter(CreateRecruiterCommand recruiterCommand);

}

package com.tamanna.schedule.recruiter.application.port.in;

import com.tamanna.schedule.recruiter.domain.Recruiter;

public interface UpdateRecruiterUseCase {

	Recruiter updateRecruiter(UpdateRecruiterCommand updateRecruiterCommand);

}

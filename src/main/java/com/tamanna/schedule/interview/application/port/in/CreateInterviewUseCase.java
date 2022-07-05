package com.tamanna.schedule.interview.application.port.in;

import com.tamanna.schedule.interview.domain.Interview;

public interface CreateInterviewUseCase {

	Interview addInterview(CreateInterviewCommand createInterviewCommand);

}

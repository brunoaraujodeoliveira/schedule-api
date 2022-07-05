package com.tamanna.schedule.interview.application.port.out;

import com.tamanna.schedule.interview.domain.Interview;

public interface CreateInterviewPort {

    Interview addInterview(Interview interview);

}

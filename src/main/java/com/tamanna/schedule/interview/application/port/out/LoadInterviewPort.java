package com.tamanna.schedule.interview.application.port.out;

import com.tamanna.schedule.interview.domain.Interview;

public interface LoadInterviewPort {

    Interview getById(Long id);

}

package com.tamanna.schedule.recruiter.application.port.out;

import java.util.List;

import com.tamanna.schedule.recruiter.domain.Recruiter;

public interface LoadRecruiterPort {

    List<Recruiter> getRecruiters();

    Recruiter getById(Long id);

}

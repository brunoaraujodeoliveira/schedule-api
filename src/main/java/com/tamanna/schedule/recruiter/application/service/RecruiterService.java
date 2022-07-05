package com.tamanna.schedule.recruiter.application.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tamanna.schedule.recruiter.application.port.in.CreateRecruiterCommand;
import com.tamanna.schedule.recruiter.application.port.in.CreateRecruiterUseCase;
import com.tamanna.schedule.recruiter.application.port.in.GetRecruiterQuery;
import com.tamanna.schedule.recruiter.application.port.in.RemoveRecruiterUseCase;
import com.tamanna.schedule.recruiter.application.port.in.UpdateRecruiterCommand;
import com.tamanna.schedule.recruiter.application.port.in.UpdateRecruiterUseCase;
import com.tamanna.schedule.recruiter.application.port.out.CreateRecruiterPort;
import com.tamanna.schedule.recruiter.application.port.out.LoadRecruiterPort;
import com.tamanna.schedule.recruiter.application.port.out.RemoveRecruiterPort;
import com.tamanna.schedule.recruiter.application.port.out.UpdateRecruiterPort;
import com.tamanna.schedule.recruiter.domain.Recruiter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class RecruiterService implements GetRecruiterQuery, CreateRecruiterUseCase, UpdateRecruiterUseCase, RemoveRecruiterUseCase {

    private final LoadRecruiterPort loadRecruiterPort;
    private final CreateRecruiterPort createRecruiterPort;
    private final RemoveRecruiterPort removeRecruiterPort;
    private final UpdateRecruiterPort updateRecruiterPort;

    @Override
    public List<Recruiter> getRecruiters() {
        return loadRecruiterPort.getRecruiters();
    }

    @Override
    public Recruiter getById(Long id) {
        return loadRecruiterPort.getById(id);
    }

    @Override
    public Recruiter addRecruiter(CreateRecruiterCommand recruiterCommand) {
        Recruiter recruiter = new Recruiter(recruiterCommand.getName());
        return createRecruiterPort.addRecruiter(recruiter);
    }

    @Override
    public Recruiter updateRecruiter(UpdateRecruiterCommand updateRecruiterCommand) {
        Recruiter recruiter = new Recruiter(
            updateRecruiterCommand.getId(),
            updateRecruiterCommand.getAvailabilityList(),
            updateRecruiterCommand.getInterviewList()
        );

        return updateRecruiterPort.updateRecruiter(recruiter);
    }

    @Override
    public void deleteRecruiter(Long id) {
        removeRecruiterPort.removeById(id);
    }

}

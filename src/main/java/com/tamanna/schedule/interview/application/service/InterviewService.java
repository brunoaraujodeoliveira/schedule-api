package com.tamanna.schedule.interview.application.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tamanna.schedule.common.exception.BusinessException;
import com.tamanna.schedule.interview.application.port.in.CreateInterviewCommand;
import com.tamanna.schedule.interview.application.port.in.CreateInterviewUseCase;
import com.tamanna.schedule.interview.application.port.in.RemoveInterviewUseCase;
import com.tamanna.schedule.interview.application.port.out.CreateInterviewPort;
import com.tamanna.schedule.interview.application.port.out.LoadInterviewPort;
import com.tamanna.schedule.interview.application.port.out.RemoveInterviewPort;
import com.tamanna.schedule.interview.domain.Interview;
import com.tamanna.schedule.recruiter.application.port.out.LoadRecruiterPort;
import com.tamanna.schedule.recruiter.application.port.out.UpdateRecruiterPort;
import com.tamanna.schedule.recruiter.domain.Recruiter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class InterviewService implements CreateInterviewUseCase, RemoveInterviewUseCase {

    private final LoadRecruiterPort loadRecruiterPort;
    private final LoadInterviewPort loadInterviewPort;
    private final UpdateRecruiterPort updateRecruiterPort;
    private final CreateInterviewPort createInterviewPort;
    private final RemoveInterviewPort removeInterviewPort;

    @Override
    public Interview addInterview(CreateInterviewCommand createInterviewCommand) {
        Interview interview = new Interview(
            createInterviewCommand.getCandidate(),
            createInterviewCommand.getRecruiter(),
            createInterviewCommand.getSlotList(),
            createInterviewCommand.getMeetLink()
        );

        Recruiter recruiter = loadRecruiterPort.getById(createInterviewCommand.getRecruiter().getId());

        boolean recruiterSlotValid = interview.getSlotList().stream().anyMatch(element -> recruiter.getAvailabilityList().contains(element));

        if (recruiterSlotValid) {
            recruiter.getAvailabilityList().removeIf(slot -> interview.getSlotList().contains(slot));

            updateRecruiterPort.updateRecruiter(recruiter);

            return createInterviewPort.addInterview(interview);
        }

        throw new BusinessException("Slot meet invalid!");
    }

    @Override
    public void deleteInterview(Long id) {
        Interview interview = loadInterviewPort.getById(id);
        Recruiter recruiter = loadRecruiterPort.getById(interview.getRecruiter().getId());

        interview.getSlotList().forEach(recruiter::addAvailability);
        updateRecruiterPort.updateRecruiter(recruiter);

        removeInterviewPort.removeById(id);
    }
}

package com.tamanna.schedule.interview.adapter.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.tamanna.schedule.common.exception.NotFoundException;
import com.tamanna.schedule.interview.application.port.out.CreateInterviewPort;
import com.tamanna.schedule.interview.application.port.out.LoadInterviewPort;
import com.tamanna.schedule.interview.application.port.out.RemoveInterviewPort;
import com.tamanna.schedule.interview.domain.Interview;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
class InterviewPersistenceAdapter implements LoadInterviewPort, CreateInterviewPort, RemoveInterviewPort {

    private final InterviewRepository interviewRepository;

    @Override
    public Interview addInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public void removeById(Long id) {
        Interview interview = Optional.of(getById(id))
            .orElseThrow(() -> new NotFoundException("Interview not found"));

        interviewRepository.delete(interview);
    }

    @Override
    public Interview getById(Long id) {
        return interviewRepository.getReferenceById(id);
    }
}

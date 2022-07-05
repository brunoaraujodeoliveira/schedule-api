package com.tamanna.schedule.recruiter.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.tamanna.schedule.common.exception.DuplicateException;
import com.tamanna.schedule.common.exception.NotFoundException;
import com.tamanna.schedule.recruiter.application.port.out.CreateRecruiterPort;
import com.tamanna.schedule.recruiter.application.port.out.LoadRecruiterPort;
import com.tamanna.schedule.recruiter.application.port.out.RemoveRecruiterPort;
import com.tamanna.schedule.recruiter.application.port.out.UpdateRecruiterPort;
import com.tamanna.schedule.recruiter.domain.Recruiter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
class RecruiterPersistenceAdapter implements LoadRecruiterPort, CreateRecruiterPort, UpdateRecruiterPort, RemoveRecruiterPort {

    private final RecruiterRepository recruiterRepository;

    @Override
    public List<Recruiter> getRecruiters() {
        return recruiterRepository.findAll();
    }

    @Override
    public Recruiter getById(Long id) {
        return recruiterRepository.getReferenceById(id);
    }

    @Override
    public Recruiter addRecruiter(Recruiter recruiter) {
        Optional.ofNullable(recruiterRepository.getByName(recruiter.getName()))
            .orElseThrow(() -> new DuplicateException("Recruiter already exists"));

        return recruiterRepository.save(recruiter);
    }

    @Override
    public Recruiter updateRecruiter(Recruiter recruiter) {
        Recruiter recruiterUpdate = Optional.of(getById(recruiter.getId()))
            .orElseThrow(() -> new NotFoundException("Recruiter not found"));

        recruiterUpdate.addInterview(recruiter.getInterviewList());
        recruiterUpdate.addAvailability(recruiter.getAvailabilityList());

        return recruiterRepository.save(recruiterUpdate);
    }

    @Override
    public void removeById(Long id) {
        Recruiter recruiter = Optional.of(getById(id))
            .orElseThrow(() -> new NotFoundException("Recruiter not found"));

        recruiterRepository.delete(recruiter);
    }
}

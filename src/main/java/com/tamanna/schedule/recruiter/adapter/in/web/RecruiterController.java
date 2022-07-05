package com.tamanna.schedule.recruiter.adapter.in.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tamanna.schedule.recruiter.application.port.in.CreateRecruiterCommand;
import com.tamanna.schedule.recruiter.application.port.in.CreateRecruiterUseCase;
import com.tamanna.schedule.recruiter.application.port.in.GetRecruiterQuery;
import com.tamanna.schedule.recruiter.application.port.in.RemoveRecruiterUseCase;
import com.tamanna.schedule.recruiter.application.port.in.UpdateRecruiterCommand;
import com.tamanna.schedule.recruiter.application.port.in.UpdateRecruiterUseCase;
import com.tamanna.schedule.recruiter.domain.Recruiter;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/recruiters")
@RequiredArgsConstructor
class RecruiterController {

    private final GetRecruiterQuery getRecruiterQuery;
    private final CreateRecruiterUseCase createRecruiterUseCase;
    private final UpdateRecruiterUseCase updateRecruiterUseCase;
    private final RemoveRecruiterUseCase removeRecruiterUseCase;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Recruiter> getRecruiters() {
        return getRecruiterQuery.getRecruiters();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Recruiter> getRecruiterById(@PathVariable("id") Long id) {
        Recruiter recruiter = getRecruiterQuery.getById(id);
        return new ResponseEntity<>(recruiter, HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Recruiter> addRecruiter(@Validated @RequestBody CreateRecruiterCommand command) {
        Recruiter recruiter = createRecruiterUseCase.addRecruiter(command);
        return new ResponseEntity<>(recruiter, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Recruiter> updateRecruiter(@PathVariable("id") Long id,
        @Validated @RequestBody UpdateRecruiterCommand command) {
        command = new UpdateRecruiterCommand(
            id,
            command.getAvailabilityList(),
            command.getInterviewList());

        Recruiter recruiter = updateRecruiterUseCase.updateRecruiter(command);

        return new ResponseEntity<>(recruiter, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRecruiter(@PathVariable(value = "id") Long id) {
        removeRecruiterUseCase.deleteRecruiter(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

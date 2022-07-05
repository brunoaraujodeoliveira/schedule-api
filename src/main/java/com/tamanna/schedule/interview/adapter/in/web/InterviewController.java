package com.tamanna.schedule.interview.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tamanna.schedule.interview.application.port.in.CreateInterviewCommand;
import com.tamanna.schedule.interview.application.port.in.CreateInterviewUseCase;
import com.tamanna.schedule.interview.application.port.in.RemoveInterviewUseCase;
import com.tamanna.schedule.interview.domain.Interview;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/interviews")
@RequiredArgsConstructor
class InterviewController {

    private final CreateInterviewUseCase createInterviewUseCase;
    private final RemoveInterviewUseCase removeInterviewUseCase;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Interview> addInterview(@Validated @RequestBody CreateInterviewCommand command) {
        Interview interview = createInterviewUseCase.addInterview(command);
        return new ResponseEntity<>(interview, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteInterview(@PathVariable(value = "id") Long id) {
        removeInterviewUseCase.deleteInterview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

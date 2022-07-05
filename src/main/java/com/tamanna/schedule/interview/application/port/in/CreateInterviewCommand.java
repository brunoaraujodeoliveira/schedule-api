package com.tamanna.schedule.interview.application.port.in;

import java.util.List;

import com.tamanna.schedule.candidate.domain.Candidate;
import com.tamanna.schedule.common.SelfValidating;
import com.tamanna.schedule.common.domain.Slot;
import com.tamanna.schedule.recruiter.domain.Recruiter;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class CreateInterviewCommand extends SelfValidating<CreateInterviewCommand> {

    @NonNull
    Candidate candidate;

    @NonNull
    Recruiter recruiter;

    @NonNull
    List<Slot> slotList;

    @NonNull
    String meetLink;

    public CreateInterviewCommand(@NonNull Candidate candidate,
        @NonNull Recruiter recruiter, @NonNull List<Slot> slotList, @NonNull String meetLink) {
        this.candidate = candidate;
        this.recruiter = recruiter;
        this.slotList = slotList;
        this.meetLink = meetLink;
        this.validateSelf();
    }
}

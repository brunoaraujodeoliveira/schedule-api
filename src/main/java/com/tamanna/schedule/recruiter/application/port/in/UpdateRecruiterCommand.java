package com.tamanna.schedule.recruiter.application.port.in;

import java.util.List;

import com.tamanna.schedule.common.SelfValidating;
import com.tamanna.schedule.common.domain.Slot;
import com.tamanna.schedule.interview.domain.Interview;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class UpdateRecruiterCommand extends SelfValidating<UpdateRecruiterCommand> {

    @Getter
    Long id;

    @Getter
    List<Slot> availabilityList;

    @Getter
    List<Interview> interviewList;

    public UpdateRecruiterCommand(
        Long id, List<Slot> availabilityList,
        List<Interview> interviewList) {
        this.id = id;
        this.availabilityList = availabilityList;
        this.interviewList = interviewList;
        this.validateSelf();
    }

}

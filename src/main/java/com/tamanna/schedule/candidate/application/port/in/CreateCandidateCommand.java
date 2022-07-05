package com.tamanna.schedule.candidate.application.port.in;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.tamanna.schedule.common.SelfValidating;
import com.tamanna.schedule.common.domain.Slot;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class CreateCandidateCommand extends SelfValidating<CreateCandidateCommand> {

    @Getter
    Long id;

    @NotNull
    String name;

    @NotNull
    @Getter
    List<Slot> availabilityList;

    public CreateCandidateCommand(
        Long id, String name, List<Slot> availabilityList) {
        this.id = id;
        this.name = name;
        this.availabilityList = availabilityList;
        this.validateSelf();
    }

}

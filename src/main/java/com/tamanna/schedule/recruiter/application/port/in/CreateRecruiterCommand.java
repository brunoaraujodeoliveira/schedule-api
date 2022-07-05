package com.tamanna.schedule.recruiter.application.port.in;

import javax.validation.constraints.NotNull;

import com.tamanna.schedule.common.SelfValidating;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class CreateRecruiterCommand extends SelfValidating<CreateRecruiterCommand> {

    @NotNull
    String name;

    public CreateRecruiterCommand(String name) {
        this.name = name;
        this.validateSelf();
    }
}

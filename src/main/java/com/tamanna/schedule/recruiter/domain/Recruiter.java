package com.tamanna.schedule.recruiter.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tamanna.schedule.common.domain.Slot;
import com.tamanna.schedule.interview.domain.Interview;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "recruiter")
@RequiredArgsConstructor
public class Recruiter {

    @Id
    @Getter
    private final Long id;

    @NonNull
    @Getter
    private String name;

    @Getter
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Slot> availabilityList;

    @Getter
    @OneToMany(
        mappedBy = "recruiter",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Interview> interviewList;

    public Recruiter(@NonNull String name) {
        this.name = name;
        this.availabilityList = new ArrayList<>();
        this.interviewList = new ArrayList<>();
        this.id = null;
    }

    public Recruiter(Long id, List<Slot> availabilityList, List<Interview> interviewList) {
        this.availabilityList = availabilityList;
        this.interviewList = interviewList;
        this.id = id;
    }

    public void addInterview(List<Interview> interviewList) {
        this.interviewList = interviewList;
    }

    public void addInterview(Interview interview) {
        this.interviewList.add(interview);
    }

    public void addAvailability(List<Slot> availabilityList) {
        this.availabilityList = availabilityList;
    }

    public void addAvailability(Slot availability) {
        this.availabilityList.add(availability);
    }

}

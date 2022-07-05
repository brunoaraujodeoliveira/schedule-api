package com.tamanna.schedule.candidate.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tamanna.schedule.common.domain.Slot;
import com.tamanna.schedule.interview.domain.Interview;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "candidate")
@RequiredArgsConstructor
public class Candidate {

    @Id
    @Getter
    private final Long id;

    @NonNull
    @Getter
    private final String name;

    @Getter
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private final List<Slot> availabilityList;

    @Getter
    @ManyToOne
    @JoinColumn(name = "interview_id")
    private final Interview interview;

    public Candidate(@NonNull String name, List<Slot> availabilityList) {
        this.name = name;
        this.availabilityList = availabilityList;
        this.interview = null;
        this.id = null;
    }

}

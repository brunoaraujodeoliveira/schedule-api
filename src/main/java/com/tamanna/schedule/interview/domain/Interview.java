package com.tamanna.schedule.interview.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tamanna.schedule.candidate.domain.Candidate;
import com.tamanna.schedule.common.domain.Slot;
import com.tamanna.schedule.recruiter.domain.Recruiter;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "interview")
@RequiredArgsConstructor
public class Interview {

    @Id
    @Getter
    private final Long id;

    @NonNull
    @Getter
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private final Candidate candidate;

    @NonNull
    @Getter
    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private final Recruiter recruiter;

    @NonNull
    @Getter
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private final List<Slot> slotList;

    @NonNull
    @Getter
    private final String meetLink;

    public Interview(@NonNull Candidate candidate, @NonNull Recruiter recruiter,
        @NonNull List<Slot> slotList, @NonNull String meetLink) {
        this.candidate = candidate;
        this.recruiter = recruiter;
        this.slotList = slotList;
        this.meetLink = meetLink;
        this.id = null;
    }

}

package com.tamanna.schedule.common.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "slot")
@RequiredArgsConstructor
@EqualsAndHashCode
public class Slot {

    @Id
    @Getter
    private final Long id;

    @NonNull
    @Getter
    private final LocalDate date;

    @NonNull
    @Getter
    private final Integer initialHour;

    @NonNull
    @Getter
    private final Integer finalHour;

    public Slot(@NonNull LocalDate date, @NonNull Integer initialHour, @NonNull Integer finalHour) {
        this.date = date;
        this.initialHour = initialHour;
        this.finalHour = finalHour;
        this.id = null;
    }

}

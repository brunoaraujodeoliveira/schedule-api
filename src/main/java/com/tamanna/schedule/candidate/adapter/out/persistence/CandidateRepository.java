package com.tamanna.schedule.candidate.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamanna.schedule.candidate.domain.Candidate;

@Repository
interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate getByName(String name);

}

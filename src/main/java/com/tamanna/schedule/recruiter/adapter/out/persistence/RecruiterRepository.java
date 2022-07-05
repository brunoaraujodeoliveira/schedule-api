package com.tamanna.schedule.recruiter.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamanna.schedule.recruiter.domain.Recruiter;

@Repository
interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

    Recruiter getByName(String name);

}

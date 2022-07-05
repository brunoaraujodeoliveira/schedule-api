package com.tamanna.schedule.interview.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamanna.schedule.interview.domain.Interview;

@Repository
interface InterviewRepository extends JpaRepository<Interview, Long> {


}

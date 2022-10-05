package com.devops.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devops.tutorial.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {}

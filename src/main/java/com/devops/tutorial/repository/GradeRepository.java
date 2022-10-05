package com.devops.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devops.tutorial.model.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {}

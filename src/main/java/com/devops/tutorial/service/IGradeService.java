package com.devops.tutorial.service;

import java.util.List;
import java.util.Map;

import com.devops.tutorial.model.Grade;

public interface IGradeService {
	
List<Grade> getAllGrades();

Grade getGradeById(Long gradeId);

Grade saveGrade(Grade grade);

Grade updateGrade(Long gradeId, Grade grade);

Map<String, Boolean> deleteGrade(Long gradeId);
}

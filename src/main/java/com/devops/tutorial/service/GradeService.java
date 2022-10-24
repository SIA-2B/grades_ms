package com.devops.tutorial.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devops.tutorial.exception.ResourceNotFoundException;
import com.devops.tutorial.model.Grade;
import com.devops.tutorial.repository.GradeRepository;

@Transactional
@Service
public class GradeService implements IGradeService{

	private static final Logger LOGGER = LoggerFactory.getLogger(GradeService.class);

	@Autowired
	private GradeRepository gradeRepository;
	
	@Override
	public List<Grade> getAllGrades() {
		return gradeRepository.findAll();
	}

	@Override
	public Grade getGradeById(Long gradeId) {
		Grade grade = new Grade();
		try {
			grade = gradeRepository.findById(gradeId).orElseThrow(() -> new ResourceNotFoundException("Grade not found on :: " + gradeId));
		} catch (ResourceNotFoundException e) {
			LOGGER.error("Error al obtener la calificación",e);
		}
		    return grade;
	}

	@Override
	public List<Grade> getAllGradesByCourseName(String courseName) {
		return gradeRepository.findByCourseName(courseName);
	}

	@Override
	public List<Grade> getAllGradesByStudentId(Integer studentId) {
		return gradeRepository.findByStudentId(studentId);
	}

	@Override
	public Grade saveGrade(Grade grade) {
		return gradeRepository.save(grade);
	}

	@Override
	public Grade updateGrade(Long gradeId, Grade gradeDet) {
		Grade updatedGrade = new Grade();
		try {
			Grade grade = new Grade();
			grade = gradeRepository.findById(gradeId).orElseThrow(() -> new ResourceNotFoundException("Grade not found on :: " + gradeId));
			grade.setStudentId(gradeDet.getStudentId());
			grade.setCourseId(gradeDet.getCourseId());
			grade.setCourseName(gradeDet.getCourseName());
			grade.setGradeFinal(gradeDet.getGradeFinal());
			grade.setGradePeriod(gradeDet.getGradePeriod());
			updatedGrade = gradeRepository.save(grade);
		} catch (ResourceNotFoundException e) {
			LOGGER.error("Error al actualizar la calificación ", e);
		}
		return updatedGrade;
	}

	@Override
	public Map<String, Boolean> deleteGrade(Long gradeId) {
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		try {
			Grade grade = gradeRepository.findById(gradeId).orElseThrow(() -> new ResourceNotFoundException("Grade not found on :: " + gradeId));
			gradeRepository.delete(grade);
			response.put("deleted", Boolean.TRUE);
		} catch (ResourceNotFoundException e) {
			response.put("deleted", Boolean.FALSE);
			LOGGER.error("Error al eliminar la calificación ", e);
		}
		return response;
	}

}

package com.devops.tutorial.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devops.tutorial.exception.ResourceNotFoundException;
import com.devops.tutorial.model.Grade;
import com.devops.tutorial.service.IGradeService;

@RestController
@RequestMapping("/api")
public class GradeController {

  @Autowired
  private IGradeService gradeService;

  @GetMapping("/grade")
  public List<Grade> getAllGrades() {
    return gradeService.getAllGrades();
  }

  @GetMapping("/grade/{id}")
  public ResponseEntity<Grade> getGradesById(@PathVariable(value = "id") Long gradeId)
      throws ResourceNotFoundException {
    Grade grade = gradeService.getGradeById(gradeId);
    return ResponseEntity.ok().body(grade);
  }

  @GetMapping("/grade/byCourseName/{courseName}")
  public List<Grade> getAllGradesByCourseName(@PathVariable(value = "courseName") String courseName){
    return gradeService.getAllGradesByCourseName(courseName);
  }

  @GetMapping("/grade/byStudentId/{studentId}")
  public List<Grade> getAllGradesByStudentId(@PathVariable(value = "studentId") Integer studentId){
    return gradeService.getAllGradesByStudentId(studentId);
  }

  @PostMapping("/grade")
  public Grade createGrade(@Valid @RequestBody Grade grade) {
	  gradeService.saveGrade(grade);
    return grade;
  }

  @PutMapping("/grade/{id}")
  public ResponseEntity<Grade> updateGrade(
      @PathVariable(value = "id") Long gradeId, @Valid @RequestBody Grade grade)
      throws ResourceNotFoundException {
    Grade updatedGrade = gradeService.updateGrade(gradeId, grade);
    return ResponseEntity.ok(updatedGrade);
  }

  @DeleteMapping("/grade/{id}")
  public Map<String, Boolean> deleteGrade(@PathVariable(value = "id") Long gradeId) throws Exception {
    return gradeService.deleteGrade(gradeId);
  }
}

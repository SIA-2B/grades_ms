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
import com.devops.tutorial.model.Schedule;
import com.devops.tutorial.service.IScheduleService;


@RestController
@RequestMapping("/api")
public class ScheduleController {

  @Autowired
  private IScheduleService scheduleService;

  @GetMapping("/schedules")
  public List<Schedule> getAllSchedules() {
    return scheduleService.getAllSchedules();
  }

  @GetMapping("/schedule/{id}")
  public ResponseEntity<Schedule> getScheduleById(@PathVariable(value = "id") Long scheduleId)
      throws ResourceNotFoundException {
        Schedule schedule = scheduleService.getScheduleById(scheduleId);
    return ResponseEntity.ok().body(schedule);
  }

  @PostMapping("/schedules")
  public Schedule createSchedule(@Valid @RequestBody Schedule schedule) {
    scheduleService.saveSchedule(schedule);
    return schedule;
  }

  @PutMapping("/schedules/{id}")
  public ResponseEntity<Schedule> updateSchedule(
      @PathVariable(value = "id") Long gradeId, @Valid @RequestBody Schedule schedule)
      throws ResourceNotFoundException {
        Schedule updatedSchedule = scheduleService.updateSchedule(gradeId, schedule);
    return ResponseEntity.ok(updatedSchedule);
  }

  @DeleteMapping("/schedule/{id}")
  public Map<String, Boolean> deleteSchedule(@PathVariable(value = "id") Long scheduleId) throws Exception {
    return scheduleService.deleteSchedule(scheduleId);
  }
}

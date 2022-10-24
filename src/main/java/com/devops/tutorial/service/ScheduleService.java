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
import com.devops.tutorial.model.Schedule;
import com.devops.tutorial.repository.ScheduleRepository;

@Transactional
@Service
public class ScheduleService implements IScheduleService{

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleService.class);

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Override
	public List<Schedule> getAllSchedules() {
		return scheduleRepository.findAll();
	}

	@Override
	public Schedule getScheduleById(Long scheduleId) {
		Schedule grade = new Schedule();
		try {
			grade = scheduleRepository.findById(scheduleId).orElseThrow(() -> new ResourceNotFoundException("Schedule not found on :: " + scheduleId));
		} catch (ResourceNotFoundException e) {
			LOGGER.error("Error al obtener el horario",e);
		}
		    return grade;
	}

	@Override
	public List<Schedule> getAllSchedulesByStudentId(Integer studentId) {
		return scheduleRepository.findByStudentId(studentId);
	}
	
	@Override
	public Schedule saveSchedule(Schedule grade) {
		return scheduleRepository.save(grade);
	}

	@Override
	public Schedule updateSchedule(Long scheduleId, Schedule scheduleDet) {
		Schedule updatedSchedule = new Schedule();
		try {
			Schedule schedule = new Schedule();
			schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new ResourceNotFoundException("Schedule not found on :: " + scheduleId));
			schedule.setStudentId(scheduleDet.getStudentId());
			schedule.setTime(scheduleDet.getTime());
            schedule.setDay(scheduleDet.getDay());
            schedule.setCourseId(scheduleDet.getCourseId());
            schedule.setTeacherId(scheduleDet.getTeacherId());
			updatedSchedule = scheduleRepository.save(schedule);
		} catch (ResourceNotFoundException e) {
			LOGGER.error("Error al actualizar el horario ", e);
		}
		return updatedSchedule;
	}

	@Override
	public Map<String, Boolean> deleteSchedule(Long scheduleId) {
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		try {
			Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new ResourceNotFoundException("Schedule not found on :: " + scheduleId));
			scheduleRepository.delete(schedule);
			response.put("deleted", Boolean.TRUE);
		} catch (ResourceNotFoundException e) {
			response.put("deleted", Boolean.FALSE);
			LOGGER.error("Error al eliminar el horario ", e);
		}
		return response;
	}

}

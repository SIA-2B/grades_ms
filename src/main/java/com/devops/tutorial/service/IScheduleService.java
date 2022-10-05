package com.devops.tutorial.service;

import java.util.List;
import java.util.Map;

import com.devops.tutorial.model.Schedule;

public interface IScheduleService {
	
List<Schedule> getAllSchedules();

Schedule getScheduleById(Long scheduleId);

Schedule saveSchedule(Schedule schedule);

Schedule updateSchedule(Long scheduleId, Schedule schedule);

Map<String, Boolean> deleteSchedule(Long scheduleId);
}

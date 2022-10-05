package com.devops.tutorial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "schedules")
@EntityListeners(AuditingEntityListener.class)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "schedule_monday", nullable = false)
    private String scheduleMonday;

    @Column(name = "schedule_tuesday", nullable = false)
    private String scheduleTuesday;

    @Column(name = "schedule_wednesday", nullable = false)
    private String scheduleWednesday;

    @Column(name = "schedule_thursday", nullable = false)
    private String scheduleThursday;

    @Column(name = "schedule_friday", nullable = false)
    private String scheduleFriday;

    @Column(name = "schedule_saturday", nullable = false)
    private String scheduleSaturday;

    @Column(name = "schedule_classroom_monday", nullable = false)
    private String scheduleClassroomMonday;

    @Column(name = "schedule_classroom_tuesday", nullable = false)
    private String scheduleClassroomTuesday;

    @Column(name = "schedule_classroom_wednesday", nullable = false)
    private String scheduleClassroomWednesday;

    @Column(name = "schedule_classroom_thursday", nullable = false)
    private String scheduleClassroomThursday;

    @Column(name = "schedule_classroom_friday", nullable = false)
    private String scheduleClassroomFriday;

    @Column(name = "schedule_classroom_saturday", nullable = false)
    private String scheduleClassroomSaturday;

 
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getScheduleMonday() {
        return scheduleMonday;
    }

    public void setScheduleMonday(String scheduleMonday) {
        this.scheduleMonday = scheduleMonday;
    }

    public String getScheduleTuesday() {
        return scheduleTuesday;
    }

    public void setScheduleTuesday(String scheduleTuesday) {
        this.scheduleTuesday = scheduleTuesday;
    }

    public String getScheduleWednesday() {
        return scheduleWednesday;
    }

    public void setScheduleWednesday(String scheduleWednesday) {
        this.scheduleWednesday = scheduleWednesday;
    }

    public String getScheduleThursday() {
        return scheduleThursday;
    }

    public void setScheduleThursday(String scheduleThursday) {
        this.scheduleThursday = scheduleThursday;
    }

    public String getScheduleFriday() {
        return scheduleFriday;
    }

    public void setScheduleFriday(String scheduleFriday) {
        this.scheduleFriday = scheduleFriday;
    }

    public String getScheduleSaturday() {
        return scheduleSaturday;
    }

    public void setScheduleSaturday(String scheduleSaturday) {
        this.scheduleSaturday = scheduleSaturday;
    }

    public String getScheduleClassroomMonday() {
        return scheduleClassroomMonday;
    }

    public void setScheduleClassroomMonday(String scheduleClassroomMonday) {
        this.scheduleClassroomMonday = scheduleClassroomMonday;
    }

    public String getScheduleClassroomTuesday() {
        return scheduleClassroomTuesday;
    }

    public void setScheduleClassroomTuesday(String scheduleClassroomTuesday) {
        this.scheduleClassroomTuesday = scheduleClassroomTuesday;
    }

    public String getScheduleClassroomWednesday() {
        return scheduleClassroomWednesday;
    }

    public void setScheduleClassroomWednesday(String scheduleClassroomWednesday) {
        this.scheduleClassroomWednesday = scheduleClassroomWednesday;
    }

    public String getScheduleClassroomThursday() {
        return scheduleClassroomThursday;
    }

    public void setScheduleClassroomThursday(String scheduleClassroomThursday) {
        this.scheduleClassroomThursday = scheduleClassroomThursday;
    }

    public String getScheduleClassroomFriday() {
        return scheduleClassroomFriday;
    }

    public void setScheduleClassroomFriday(String scheduleClassroomFriday) {
        this.scheduleClassroomFriday = scheduleClassroomFriday;
    }

    public String getScheduleClassroomSaturday() {
        return scheduleClassroomSaturday;
    }

    public void setScheduleClassroomSaturday(String scheduleClassroomSaturday) {
        this.scheduleClassroomSaturday = scheduleClassroomSaturday;
    }

}
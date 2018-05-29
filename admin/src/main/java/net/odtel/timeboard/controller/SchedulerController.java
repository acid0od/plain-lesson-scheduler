/* ===========================================================================
 * Copyright (c) 2015 Comcast Corp. All rights reserved.
 * ===========================================================================
 *
 * Author: Alexander Ievstratiev
 * Created: 04/23/2018  4:40 PM
 */
package net.odtel.timeboard.controller;

import lombok.extern.slf4j.Slf4j;
import net.odtel.timeboard.model.Scheduler;
import net.odtel.timeboard.model.SubjectCourse;
import net.odtel.timeboard.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Slf4j
public class SchedulerController {

    @Autowired
    private SchedulerService schedulerService;

    @GetMapping(path = "/{semester}/{week}/")
    public ResponseEntity<List<Scheduler>> getSchedulerByWeek(@PathVariable("semester") int semester,
                                                              @PathVariable("week") int week) {
        return new ResponseEntity<>(schedulerService.getSchedulerBySemesterAndWeek(semester, week), HttpStatus.OK);
    }

    @GetMapping(path = "/subjectCourse/{subject}")
    public ResponseEntity<SubjectCourse> getSubjectCourse(@PathVariable("subject") String subject) {
        return new ResponseEntity<>(schedulerService.getSubjectCourse(subject), HttpStatus.OK);
    }

    @GetMapping(path = "/subjectCourse/")
    public ResponseEntity<List<SubjectCourse>> getSubjectCourses() {
        return new ResponseEntity<>(schedulerService.getAllSubjectCourses(), HttpStatus.OK);
    }


    @GetMapping(path = "/")
    public ResponseEntity<List<Scheduler>> getAllScheduler() {
        return new ResponseEntity<>(schedulerService.getAllSchedulers(), HttpStatus.OK);
    }

    @PostMapping(path = "/scheduler/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody Scheduler scheduler) {
        schedulerService.create(scheduler);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/scheduler/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@PathVariable("id") UUID id,
                                       @RequestBody Scheduler scheduler) {
        schedulerService.update(id, scheduler);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

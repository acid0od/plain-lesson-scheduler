/* ===========================================================================
 * Copyright (c) 2015 Comcast Corp. All rights reserved.
 * ===========================================================================
 *
 * Author: Alexander Ievstratiev
 * Created: 04/23/2018  5:14 PM
 */
package net.odtel.timeboard.service;

import com.datastax.driver.core.utils.UUIDs;
import net.odtel.timeboard.model.Scheduler;
import net.odtel.timeboard.model.Subject;
import net.odtel.timeboard.model.SubjectCourse;
import net.odtel.timeboard.model.TeachingForm;
import net.odtel.timeboard.repository.SchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SchedulerService {
    @Autowired
    private SchedulerRepository repository;

    public List<Scheduler> getSchedulerBySemesterAndWeek(int semester, int week) {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Scheduler> getAllSchedulers() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Scheduler getById(UUID id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void create(Scheduler scheduler) {
        scheduler.setId(UUIDs.timeBased());
        repository.save(scheduler);
    }

    public void update(UUID uuid, Scheduler scheduler) {
        scheduler.setId(uuid);
        repository.save(scheduler);
    }

    public SubjectCourse getSubjectCourse(String subject) {
        SubjectCourse course = new SubjectCourse(subject, new HashMap<String, Integer>());

        List<Scheduler> collect = StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .filter(scheduler -> subject.equals(scheduler.getSubjectName()))
                .peek(scheduler -> course.add(scheduler.getSubjectType(), scheduler.getHours()))
                .collect(Collectors.toList());


        return course;
    }
}

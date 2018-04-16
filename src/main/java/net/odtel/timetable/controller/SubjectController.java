/* ===========================================================================
 * Copyright (c) 2015 Comcast Corp. All rights reserved.
 * ===========================================================================
 *
 * Author: Alexander Ievstratiev
 * Created: 04/16/2018  7:11 PM
 */
package net.odtel.timetable.controller;

import net.odtel.timetable.model.Subject;
import net.odtel.timetable.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Subject>> isNotificationPartnerLevelPresent() {
        return service.getAll();
    }

}

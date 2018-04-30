/* ===========================================================================
 * Copyright (c) 2015 Comcast Corp. All rights reserved.
 * ===========================================================================
 *
 * Author: Alexander Ievstratiev
 * Created: 04/26/2018  5:38 PM
 */
package net.odtel.timeboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SubjectCourse {
    private String title;
    private Map<String, Integer> teachingForms = new HashMap<>();

    public SubjectCourse(String title, String subjectType, int hours) {
        this.title = title;
        this.teachingForms.put(subjectType, hours);
    }

    public void add(String subjectType, int hours) {
        Integer addedHours = hours;
        if (teachingForms.containsKey(subjectType)) {
            addedHours = teachingForms.get(subjectType) + hours;
        }

        teachingForms.put(subjectType, addedHours);
    }

    public void add(Map<String,Integer> teachingForms) {
        for (Map.Entry<String, Integer> stringIntegerEntry : teachingForms.entrySet()) {
            this.add(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
    }
}

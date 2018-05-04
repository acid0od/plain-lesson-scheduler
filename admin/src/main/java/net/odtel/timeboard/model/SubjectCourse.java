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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class SubjectCourse {
    @NonNull
    private String title;

    private int lecture = 0;
    private int practical = 0;
    private int laboratoryWork = 0;
    private int courseWork = 0;
    private int exam = 0;
    private int credit = 0;

    public static SubjectCourse of(String subjectName, TeachingFormType teachingFormType, int hours) {
        SubjectCourse subjectCourse = new SubjectCourse(subjectName);
        subjectCourse.addHoursForGivenTeachingForm(teachingFormType, hours);
        return subjectCourse;
    }

    public void addHoursForGivenTeachingForm(TeachingFormType teachingFormType, int hours) {
        if (teachingFormType == null || hours < 0) {
            throw new RuntimeException("Unknown type");
        }

        switch (teachingFormType) {
            case LECTURE:
                this.lecture += hours;
                break;
            case PRACTICAL:
                this.practical += hours;
                break;
            case LABORATORYWORK:
                this.laboratoryWork += hours;
                break;
            case COURSEWORK:
                this.courseWork += hours;
                break;
            case EXAM:
                this.exam += hours;
                break;
            case CREDIT:
                this.credit += hours;
                break;
            default:
                throw new RuntimeException("Unknown type");
        }
    }

    public void plus(SubjectCourse subjectCourse) {
        if (subjectCourse.getTitle() == null ||
                !this.getTitle().equals(subjectCourse.getTitle())) {
            throw new RuntimeException("different subjects");
        }

        this.lecture += subjectCourse.lecture ;
        this.practical += subjectCourse.practical ;
        this.laboratoryWork += subjectCourse.laboratoryWork ;
        this.courseWork += subjectCourse.courseWork ;
        this.exam += subjectCourse.exam ;
        this.credit += subjectCourse.credit ;
    }
}

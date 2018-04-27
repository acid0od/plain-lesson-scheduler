import { Component, OnInit } from '@angular/core';
import { SubjectCourse } from '../model/subject-course-model';
import { ActivatedRoute, Router } from '@angular/router';
import { SchedulerService } from './scheduler.service';

@Component({
  selector: 'ek-subject-course-list',
  templateUrl: './subject-course-list.component.html',
  styleUrls: ['./subject-course-list.component.scss']
})
export class SubjectCourseListComponent implements OnInit {
  public subjectCourses: SubjectCourse;

  constructor(public schedulerService: SchedulerService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  public ngOnInit() {
    this.schedulerService.getSubjectCourse()
      .subscribe((result) => {
        this.subjectCourses = result;
        console.log("result" + JSON.stringify(result));
      }, (error => {
        console.log("error" + JSON.stringify(error));
      }));

  }

}

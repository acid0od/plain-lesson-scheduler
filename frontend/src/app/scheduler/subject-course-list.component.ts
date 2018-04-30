import { Component, OnInit } from '@angular/core';
import { SubjectCourse } from '../model/subject-course-model';
import { ActivatedRoute, Router } from '@angular/router';
import { SchedulerService } from './scheduler.service';
import { DataSource } from '@angular/cdk/collections';
import { MatTableDataSource } from '@angular/material';

@Component({
  selector: 'ek-subject-course-list',
  templateUrl: './subject-course-list.component.html',
  styleUrls: ['./subject-course-list.component.scss']
})
export class SubjectCourseListComponent implements OnInit {
  public subjectCourses: SubjectCourse[];
  public displayedColumns = ['title'];
  public dataSource: DataSource<SubjectCourse>;

  constructor(public schedulerService: SchedulerService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  public ngOnInit() {
    this.getSubjectCourses();
  }

  private getSubjectCourses() {
    this.schedulerService.getSubjectCourses()
      .subscribe((subjectCourses) => {
          this.subjectCourses = subjectCourses;
          this.dataSource = new MatTableDataSource<SubjectCourse>(subjectCourses);
        }, (error) => {
          console.log('Error' + error);
        }
      );
  }

}

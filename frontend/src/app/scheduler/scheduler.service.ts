import { Injectable } from '@angular/core';
import { ApiService } from '../shared/api.service';
import { SubjectCourse } from '../model/subject-course-model';
import { Observable } from 'rxjs/index';

@Injectable()
export class SchedulerService {
  private apiUrl = 'api/subjectCourse/';

  constructor(private api: ApiService) {
  }

  public getSubjectCourse(subjectName: string): Observable<SubjectCourse> {
    return this.api.get<SubjectCourse>(this.apiUrl + subjectName);
  }

  public getSubjectCourses(): Observable<SubjectCourse[]> {
    return this.api.get<SubjectCourse[]>(this.apiUrl);
  }
}

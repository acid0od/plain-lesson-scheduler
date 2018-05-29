import { Injectable } from '@angular/core';
import { ApiService } from '../shared/api.service';
import { SubjectCourse } from '../model/subject-course-model';
import { Observable } from 'rxjs/index';
import { Scheduler } from '../model/scheduler-model';

@Injectable()
export class SchedulerService {
  private apiUrl = 'api/subjectCourse/';
  private postApiUrl = 'api/scheduler/';

  constructor(private api: ApiService) {
  }

  public getSubjectCourse(subjectName: string): Observable<SubjectCourse> {
    return this.api.get<SubjectCourse>(this.apiUrl + subjectName);
  }

  public getSubjectCourses(): Observable<SubjectCourse[]> {
    return this.api.get<SubjectCourse[]>(this.apiUrl);
  }

  public saveScheduler(scheduler: Scheduler): Observable<void> {
    return this.api.post<void>(this.postApiUrl, scheduler);
  }
}

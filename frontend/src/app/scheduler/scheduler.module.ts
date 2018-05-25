import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SchedulerService } from './scheduler.service';
import { SubjectCourseListComponent } from './subject-course-list.component';
import { SharedModule } from '../shared/shared.module';
import { SchedulerRoutingModule } from './scheduler-routing.module';
import { SchedulerEditComponent } from './scheduler-edit.component';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    SchedulerRoutingModule,
  ],
  declarations: [SubjectCourseListComponent,
    SchedulerEditComponent],
  providers: [SchedulerService]
})
export class SchedulerModule {
}

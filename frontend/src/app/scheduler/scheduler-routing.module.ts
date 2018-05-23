import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { SubjectCourseListComponent } from './subject-course-list.component';

const schedulerRoutes: Routes = [
  {
    path: '', component: SubjectCourseListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(schedulerRoutes)],
  exports: [RouterModule]
})
export class SchedulerRoutingModule {
}

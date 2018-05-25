import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { SubjectCourseListComponent } from './subject-course-list.component';
import { SchedulerEditComponent } from './scheduler-edit.component';

const schedulerRoutes: Routes = [
  {
    path: '', component: SubjectCourseListComponent
  },
  {
    path: 'edit', component: SchedulerEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(schedulerRoutes)],
  exports: [RouterModule]
})
export class SchedulerRoutingModule {
}

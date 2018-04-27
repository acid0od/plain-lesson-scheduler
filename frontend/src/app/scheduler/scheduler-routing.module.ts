import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { SubjectCourseListComponent } from './subject-course-list.component';

const routes: Routes = [
  {
    path: '', component: SubjectCourseListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SchedulerRoutingModule {
}

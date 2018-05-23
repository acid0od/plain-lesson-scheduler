import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SubjectsListComponent } from './subjects-list.component';
import { SubjectsEditComponent } from './subjects-edit.component';

const subjectsRoutes: Routes = [
  /*{
    path: '', component: SubjectsListComponent
  },
  {
    path: 'edit', component: SubjectsEditComponent
  },
  {
    path: ':id', component: SubjectsEditComponent
  }*/
  {
    path: '',
    component: SubjectsListComponent,
    children: [
      {path: 'edit', component: SubjectsEditComponent},
      {path: ':id', component: SubjectsEditComponent}
    ]
  }

];

@NgModule({
  imports: [RouterModule.forChild(subjectsRoutes)],
  exports: [RouterModule]
})
export class SubjectsRoutingModule {
}

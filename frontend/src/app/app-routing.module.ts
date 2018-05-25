import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { NoContentComponent } from './no-content/no-content.component';

const routes: Routes = [
  { path: '', redirectTo: 'scheduler', pathMatch: 'full' },
  {
    path: 'scheduler',
    data: { preload: true },
    loadChildren: './scheduler/scheduler.module#SchedulerModule'
  },
  {
    path: 'subjects',
    data: { preload: true },
    loadChildren: './subjects/subjects.module#SubjectsModule'
  },

  { path: '**', component: NoContentComponent },
];


@NgModule({
  // imports: [RouterModule.forRoot(routes, { useHash: true, preloadingStrategy: PreloadAllModules })],
  imports: [RouterModule.forRoot(routes, { useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { NoContentComponent } from './no-content/no-content.component';

const routes: Routes = [
  { path: '', redirectTo: 'scheduler', pathMatch: 'full' },
  {
    path: 'scheduler',
    data: { preload: true },
    loadChildren: 'app/scheduler/scheduler.module#SchedulerModule'
  },
  { path: '**', component: NoContentComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true, preloadingStrategy: PreloadAllModules })],
  exports: [RouterModule]
})
export class AppRoutingModule { }

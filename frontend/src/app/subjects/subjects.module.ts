import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../shared/shared.module';
import { SubjectsService } from './subjects.service';
import { SubjectsEditComponent } from './subjects-edit.component';
import { SubjectsListComponent } from './subjects-list.component';
import { SubjectsRoutingModule } from './subjects-routing.module';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    SubjectsRoutingModule,
  ],
  declarations: [SubjectsListComponent, SubjectsEditComponent],
  providers: [SubjectsService]
})
export class SubjectsModule {
}

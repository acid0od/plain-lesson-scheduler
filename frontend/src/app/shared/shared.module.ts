import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from './api.service';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { CdkTableModule } from '@angular/cdk/table';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    CdkTableModule,
    MatTableModule,
  ],
  exports: [
    CdkTableModule,
    MatTableModule,
  ],
  declarations: [],
  providers: []
})
export class SharedModule {
  static forRoot() {
    return {
      ngModule: SharedModule,
      providers: [ApiService]
    }
  }
}

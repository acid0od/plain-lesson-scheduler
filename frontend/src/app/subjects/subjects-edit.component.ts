import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'ek-subjects-edit',
  templateUrl: './subjects-edit.component.html',
  styleUrls: ['./subjects-edit.component.scss']
})
export class SubjectsEditComponent implements OnInit {
  public subjectForm: FormGroup;

  constructor(public fb: FormBuilder) {
  }

  ngOnInit() {
  }

  private formBuild(): void {
    this.subjectForm = this.fb.group({
      persistenceDuration: ['']
    }, {updateOn: 'blur'});
  }
}

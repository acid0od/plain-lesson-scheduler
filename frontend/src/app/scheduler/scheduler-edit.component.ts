import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SchedulerService } from './scheduler.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'ek-scheduler-edit',
  templateUrl: './scheduler-edit.component.html',
  styleUrls: ['./scheduler-edit.component.scss']
})
export class SchedulerEditComponent implements OnInit {
  public schedulerForm: FormGroup;
  public types: string[] = ["lecture", "practical", "laboratoryWork", "courseWork", "exam", "credit"];

  constructor(public schedulerService: SchedulerService,
              private fb: FormBuilder,
              private router: Router,
              private route: ActivatedRoute) {
  }

  public ngOnInit() {
    this.formBuild();
  }

  public save() {
    const value = this.schedulerForm.value;
    console.log("Log:" + value);
  }

  private formBuild(): void {
    this.schedulerForm = this.fb.group({
      subjectName: [''],
      subjectType: [''],
      semester: [0],
      week: [0],
      hours: [0]
    }, {updateOn: 'blur'});
  }
}

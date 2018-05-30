import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SchedulerService } from './scheduler.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Scheduler } from '../model/scheduler-model';

@Component({
  selector: 'ek-scheduler-edit',
  templateUrl: './scheduler-edit.component.html',
  styleUrls: ['./scheduler-edit.component.scss']
})
export class SchedulerEditComponent implements OnInit {
  public schedulerForm: FormGroup;
  public types: string[] = ["lecture", "practical", "laboratoryWork", "courseWork", "exam", "credit"];
  public semesters: string[] = ["1", "2", "3", "4"];

  constructor(public schedulerService: SchedulerService,
              private fb: FormBuilder,
              private router: Router,
              private route: ActivatedRoute) {
  }

  public ngOnInit() {
    this.formBuild();
  }

  public save() {
    const scheduler = new Scheduler();
    const value = this.schedulerForm.value;
    scheduler.hours = value.hours;
    scheduler.semester = value.semester;
    scheduler.subjectName = value.subjectName;
    scheduler.subjectType = value.subjectType;
    scheduler.week = value.week;

    this.schedulerService.saveScheduler(scheduler)
      .subscribe(() => {
        console.log("Log:" + JSON.stringify(scheduler));
        this.goBack();
      }, (error => {
        console.log("Error:" + JSON.stringify(error));
      }))
  }

  private goBack(): void {
    this.router.navigate(['./scheduler']);
  }

  private formBuild(): void {
    this.schedulerForm = this.fb.group({
      subjectName: [''],
      subjectType: [0],
      semester: [0],
      week: [0],
      hours: [0]
    }, {updateOn: 'blur'});
  }
}

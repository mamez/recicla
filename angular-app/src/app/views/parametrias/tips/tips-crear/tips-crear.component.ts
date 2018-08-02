import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '../../../../../../node_modules/@angular/forms';

@Component({
  selector: 'app-tips-crear',
  templateUrl: './tips-crear.component.html',
  styles: []
})
export class TipsCrearComponent implements OnInit {
  public formularioTips: FormGroup;
  public uploadConfig = '/jobGreen/resourcess/images/upload/TIPS_MODEL';

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.formularioTips = this.formBuilder.group({
      titulo: ['',
              [ Validators.required, Validators.email ]],
      descripcion: ['',
              [Validators.required]]
    });
  }

  public crear(formValue: any) {
    console.log(formValue);
    // { email:'info@angular.io' }
  }

  refreshImages(status) {
    if (status === true) {
      console.log( 'Uploaded successfully!');
    }
  }

}

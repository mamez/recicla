import { Component, EventEmitter, OnInit, Output } from "@angular/core";
import {
  FormBuilder,
  FormGroup,
  Validators
} from "../../../../../../node_modules/@angular/forms";
import { Router } from "../../../../../../node_modules/@angular/router";
import { ModalDirective } from "../../../../../../node_modules/ngx-bootstrap/modal";
import { TipsModel } from "../../../../model/tips-model";
import { TipsService } from "../../../../services/tips.service";

@Component({
  selector: "app-tips-crear",
  templateUrl: "./tips-crear.component.html",
  styles: []
})
export class TipsCrearComponent implements OnInit {
  public formularioTips: FormGroup;
  public nombreImagen: string;
  public uploadConfig = "/jobGreen/resourcess/images/upload/TIPS_MODEL";
  public modal: ModalDirective;
  @Output() estadoGuardado: EventEmitter<any> = new EventEmitter<any>();

  constructor(
    private formBuilder: FormBuilder,
    private tipsService: TipsService,
    private router: Router
  ) {}

  ngOnInit() {
    this.formularioTips = this.formBuilder.group({
      titulo: ["", [Validators.required]],
      descripcion: ["", [Validators.required]]
    });
  }

  public crear(formValue: any) {
    const tips: TipsModel = new TipsModel();
    tips.titulo = formValue.titulo;
    tips.descripcion = formValue.descripcion;
    tips.imagen = this.nombreImagen;
    this.tipsService.saveTips(tips).subscribe(this.tipsGuargadoOK.bind(this));
  }

  refreshImages(nombreImagen: string) {
    if (nombreImagen !== "NOK") {
      this.nombreImagen = nombreImagen;
    }
  }

  tipsGuargadoOK(data: any) {
    this.modal.hide();
    this.estadoGuardado.emit(true);
    // this.ngOnInit();
  }

  setModal($event: ModalDirective) {
    this.modal = $event;
  }
}

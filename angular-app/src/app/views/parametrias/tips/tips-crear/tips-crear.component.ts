import { Component, EventEmitter, OnInit, Output, ViewChild } from "@angular/core";
import {
  FormBuilder,
  FormGroup,
  Validators
} from "../../../../../../node_modules/@angular/forms";
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

  @ViewChild("largeModal") modal: any;
  context: Map<string, any>;

  constructor(private formBuilder: FormBuilder, private tipsService: TipsService) {}

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
    this.context = new Map<string, any>();
    this.context.set('accion' , 'listar');
    this.context.set('evento' , 'creado');
    this.tipsService.contextoService.next(this.context);
    this.modal.hide();
  }

}

import {
  Component,
  EventEmitter,
  OnInit,
  Output,
  ViewChild
} from "@angular/core";
import { TipsModel } from "../../../../model/tips-model";
import { TipsService } from "../../../../services/tips.service";

@Component({
  selector: "app-tips-eliminar",
  templateUrl: "./tips-eliminar.component.html",
  styles: []
})
export class TipsEliminarComponent implements OnInit {
  @ViewChild("modalEliminar") modal: any;
  model: TipsModel = new TipsModel();
  context: Map<string, any>;

  constructor(private tipsService: TipsService) {
    this.tipsService.contextoService.subscribe(val => {
      this.initContext(val);
    });
  }

  private initContext(data: Map<string, any>) {
    const accion = data.get('accion');
    switch (accion) {
      case 'eliminar': {
        this.model = data.get("data");
        this.modal.show();
        break;
      }
    }
  }

  ngOnInit() {}

  public elimarTips() {
    this.tipsService.deleteTips(this.model.id).subscribe(data => {
       this.closeModal(data);
    });
  }

  private closeModal(data: any) {
    this.modal.hide();
    this.context = new Map<string, any>();
    this.context.set('accion' , 'listar');
    this.context.set('evento' , 'eliminado');
    this.tipsService.contextoService.next(this.context);
  }

}

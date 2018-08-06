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
  @Output() estadoEliminado: EventEmitter<any> = new EventEmitter<any>();

  constructor(private tipsService: TipsService) {
    this.tipsService.popup.subscribe(val => {
      this.openModal(val);
    });
  }

  ngOnInit() {}

  public elimarTips() {
    console.log(this.model);
    this.tipsService.deleteTips(this.model.id).subscribe(data => {
      this.estadoEliminado.emit(true);
      this.modal.hide();
    });
  }

  private openModal(data: Map<string, any>) {
    const accion = data.get('accion');
    if (accion === 'eliminar') {
      this.model = data.get("data");
      this.modal.show();
    }
  }
}

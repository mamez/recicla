export enum alertType {
  SUCCESS = 'success', INFO =  'info', DANGER = 'danger'
}

export class AlertModel {
  constructor(
    public msg: string,
    public activate: boolean,
    public type: alertType,
    public dismissible: boolean = true
  ) {}
}

export enum EstadoPuntoRecoleccion {
  ATENDIDO, EN_PROCESO, CANCELADO
}
export class PuntosCriticosModel {
  public id: number;
  public estado: EstadoPuntoRecoleccion;
  public fechaRecoleccion: string;
  public fechaReporte: string;
  public imagen: string;
  public lat: number;
  public lng: number;
  public observacionAdmin: string;
  public observacionUser: string;
  public direccion: string;
}

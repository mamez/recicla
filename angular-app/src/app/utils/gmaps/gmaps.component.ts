import { Component, OnInit, ViewChild } from '@angular/core';
import { } from '@types/googlemaps';

@Component({
  selector: 'app-gmaps',
  templateUrl: './gmaps.component.html',
  styleUrls: ['./gmaps.component.scss']
})
export class GmapsComponent implements OnInit {

  @ViewChild('gmap') gmapElement: any;
  map: google.maps.Map;
  marker: google.maps.Marker;
  constructor() { }

  ngOnInit() {
    setTimeout(() => {
      const mapProp = {
        center: new google.maps.LatLng(18.5793, 73.8143),
        zoom: 15,
        mapTypeId: google.maps.MapTypeId.ROADMAP
      };
      this.map = new google.maps.Map(this.gmapElement.nativeElement, mapProp);
     this.marker = new google.maps.Marker({position: mapProp.center, map: this.map});
     google.maps.event.addListener(this.marker, 'click', () => {
      console.log(this.marker.getPosition());
    });
   }, 3000);
  }

}

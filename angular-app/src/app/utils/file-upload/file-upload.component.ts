import { HttpClient, HttpHeaders } from "@angular/common/http";
import {
  Component,
  EventEmitter,
  HostListener,
  Input,
  OnInit,
  Output
} from "@angular/core";

@Component({
  selector: "app-file-upload",
  templateUrl: "./file-upload.component.html",
  styles: []
})
export class FileUploadComponent implements OnInit {
  errors: Array<string> = [];
  dragAreaClass = "dragarea";
  fileExt = "JPG, JPEG";
  maxFiles = 1;
  maxSize = 5; // 5MB
  @Output() uploadStatus = new EventEmitter();
  @Input() url;

  constructor(private http: HttpClient) {}

  ngOnInit() {}

  onFileChange(event) {
    const files = event.target.files;
    this.saveFiles(files);
  }

  @HostListener("dragover", ["$event"])
  onDragOver(event) {
    this.dragAreaClass = "droparea";
    event.preventDefault();
  }

  @HostListener("dragenter", ["$event"])
  onDragEnter(event) {
    this.dragAreaClass = "droparea";
    event.preventDefault();
  }

  @HostListener("dragend", ["$event"])
  onDragEnd(event) {
    this.dragAreaClass = "dragarea";
    event.preventDefault();
  }

  @HostListener("dragleave", ["$event"])
  onDragLeave(event) {
    this.dragAreaClass = "dragarea";
    event.preventDefault();
  }
  @HostListener("drop", ["$event"])
  onDrop(event) {
    this.dragAreaClass = "dragarea";
    event.preventDefault();
    event.stopPropagation();
    const files = event.dataTransfer.files;
    this.saveFiles(files);
  }

  saveFiles(files) {
    this.errors = []; // Clear error
    // Validate file size and allowed extensions
    if (files.length > 0 && !this.isValidFiles(files)) {
      this.uploadStatus.emit("NOK");
      return;
    }

    if (files.length > 0) {
      const formData: FormData = new FormData();
      for (let j = 0; j < files.length; j++) {
        formData.append("file", files[j], files[j].name);
      }
      this.upload(formData).subscribe(
        success => {
          const objResp: any = success;
          this.uploadStatus.emit(objResp.nombre);
          this.errors.push(objResp.nombre);
        },
        error => {
          this.uploadStatus.emit("NOK");
          this.errors.push(error.ExceptionMessage);
        }
      );
    }
  }

  private isValidFiles(files) {
    // Check Number of files
    if (files.length > this.maxFiles) {
      this.errors.push(
        "Error: No se puede subir mas de " + this.maxFiles + " Archivos"
      );
      return;
    }
    this.isValidFileExtension(files);
    return this.errors.length === 0;
  }

  private isValidFileExtension(files) {
    // Make array of file extensions
    const extensions = this.fileExt.split(",").map(function(x) {
      return x.toLocaleUpperCase().trim();
    });

    for (let i = 0; i < files.length; i++) {
      // Get file extension
      const ext =
        files[i].name
          .toUpperCase()
          .split(".")
          .pop() || files[i].name;
      // Check the extension exists
      const exists = extensions.includes(ext);
      if (!exists) {
        this.errors.push("Error Extension no vaida: " + files[i].name);
      }
      // Check file size
      this.isValidFileSize(files[i]);
    }
  }

  private isValidFileSize(file) {
    const fileSizeinMB = file.size / (1024 * 1000);
    const size = Math.round(fileSizeinMB * 100) / 100; // convert upto 2 decimal place
    if (size > this.maxSize) {
      this.errors.push(
        "Error el archivo: " +
          file.name +
          ": Supera el limite de los " +
          this.maxSize +
          "MB ( " +
          size +
          "MB )"
      );
    }
  }

  upload(files) {
    const headers = new HttpHeaders();
    return this.http.post(this.url, files, { headers: headers });
  }
}

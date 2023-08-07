import { Component, OnInit } from '@angular/core';
import { UploadFileService } from '../upload-file.service';
import { Observable } from 'rxjs';
import { HttpClient, HttpEventType, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-upload-files',
  templateUrl: './upload-files.component.html',
  styleUrls: ['./upload-files.component.css']
})
export class UploadFilesComponent implements OnInit {

  selectedFiles: FileList | undefined;
  currentFile!: File | null | undefined;
  progress = 0;
  message = '';

  fileInfos: Observable<any> | undefined;

  selectFile(event: any) {
    this.selectedFiles = event.target.files;
  }

  upload() {
    this.progress = 0;

    const currentFile: any = this.selectedFiles?.item(0);
    //const file: any = files.item(0);
    this.uploadService.upload(currentFile).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          console.log('event', event)
          //this.progress = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          console.log('upload response', event)
          this.message = event.body.message;
          this.fileInfos = this.uploadService.getFiles();
        }
      },
      err => {
        this.progress = 0;
        this.message = 'Could not upload the file!';
        this.currentFile = undefined;
      });

    this.selectedFiles = undefined;
  }

  downloadFile(file: any) {
console.log('file 1',file)
    this.uploadService.downloadFile(file.id).subscribe((response: Blob) => {
      const blob = new Blob([response], { type: response.type });

      const link = document.createElement('a');
      link.href = window.URL.createObjectURL(blob);
      link.download = file.name; // Adjust the filename using the dynamic ID
      link.click();
    });
    
     

    this.http.get(file.url, { responseType: 'blob' }).subscribe((response: Blob) => {
      console.log("response", file);

      // const blob = new Blob([response], { type: 'application/octet-stream' })
      // const url = window.URL.createObjectURL(blob);
      // const link = document.createElement('a');
      // link.href = url;
      // console.log("link", link)
      // link.href = file.url;
      // link.target = '_blank';
      // link.download = file.name;
      // link.click();
    });


  }

  constructor(private uploadService: UploadFileService,
    private http: HttpClient) { }

  ngOnInit(): void {
    this.fileInfos = this.uploadService.getFiles();
    console.log("this.fileInfos", this.fileInfos)
  }

}

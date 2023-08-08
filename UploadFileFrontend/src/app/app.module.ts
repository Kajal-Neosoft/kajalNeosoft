import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UploadFilesComponent } from './upload-files/upload-files.component';
import { UploadFileService } from './upload-file.service';
import { HttpClientModule} from '@angular/common/http';
import { EmployeeListComponent } from './employee-list/employee-list.component'
import { EmployeeListService } from './employee-list.service';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    UploadFilesComponent,
    EmployeeListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  
  ],
  providers: [UploadFileService,EmployeeListService],
  bootstrap: [AppComponent]
})
export class AppModule { }

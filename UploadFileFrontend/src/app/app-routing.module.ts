import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UploadFilesComponent } from './upload-files/upload-files.component';

const routes: Routes = [
  // {path:"",redirectTo:"uploadFiles",pathMatch:"full"},
  {path:"employeeList",component:EmployeeListComponent},
  {path:"uploadFiles",component:UploadFilesComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

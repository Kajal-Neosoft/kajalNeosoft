import { Component, Input, OnInit } from '@angular/core';
import { employee } from '../employee';
import { EmployeeListService } from '../employee-list.service';
import { Page } from '../page.interface';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  @Input() pageSize: number = 4;

  employees: employee[] | undefined;
  currentPage = 0;
  //pageSize = 4;
  totalElements = 0;

  constructor(private employeeService: EmployeeListService) { }

  ngOnInit(): void {
    this.loadEmployees();
  }

  loadEmployees(): void {
    this.employeeService.getAllEmployees(this.currentPage, this.pageSize)
      .subscribe((page: Page<employee>) => {
        console.log(this.loadEmployees)
        this.employees = page.content;
        this.totalElements = page.totalElements;
      });
  }

  onPageChange(page: number): void {
    this.currentPage = page;
    this.loadEmployees();
  }

  getPageIndexes(): number[] {
    const totalPages = Math.ceil(this.totalElements / this.pageSize);
    return Array.from({ length: totalPages }, (_, index) => index);
  }

  onPageSizeChange(newPageSize: number): void {
    this.currentPage = 0; // Reset to the first page
    this.loadEmployees(); // Reload employees with new page size
    this.pageSize = newPageSize; // Update pageSize

  }

}

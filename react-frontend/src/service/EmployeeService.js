import axios from 'axios';


const EMPLOYEE_API_BASE_URL = "http://localhost:8080/employee";

class EmployeeService
{
    getEmployees()
    {
        return axios.get(EMPLOYEE_API_BASE_URL + '/findall')
    }

    createEmployee(employee)
    {
        return axios.post(EMPLOYEE_API_BASE_URL + '/save',employee )
    }

    getEmployeeById(employeeId)
    {
        return axios.get(EMPLOYEE_API_BASE_URL + '/findbyid/'+ employeeId)
    }

    updateEmployee(employeeId,employee)
    {
        return axios.put(EMPLOYEE_API_BASE_URL + '/update/' + employeeId,employee);
    }

    deleteEmployee(employeeId)
    {
        return axios.delete(EMPLOYEE_API_BASE_URL + '/delete/' + employeeId);
    }
}

export default new EmployeeService()
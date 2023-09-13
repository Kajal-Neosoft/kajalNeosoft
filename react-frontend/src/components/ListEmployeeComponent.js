import React, { Component } from 'react';
import EmployeeService from '../service/EmployeeService';
import { Link } from 'react-router-dom';


//class component
class ListEmployeeComponent extends Component {
     
    constructor(props){
        super(props)

        this.state = {
            employees: []
        }


        // this.addEmployee = this.addEmployee.bind(this);
        // this.editEmployee = this.editEmployee.bind(this)
    }

    
    deleteEmployee(id){
        EmployeeService.deleteEmployee(id).then( res => {
            this.setState({employees: this.state.employees.filter(employee => employee.id !== id)});
        });
    }

    // editEmployee(id){
    //     // <Link to={`/update-employee/${id}`} />
    //     <Navigate to={`/update-employee/${id}`}  />

    // }

    // it will call rest api once the component mount
    componentDidMount()
    {
        EmployeeService.getEmployees().then((res) =>{
            this.setState({employees: res.data})

        });
    }

    //reac router sare path ka history mentain krta hai vo as props rehta hai isliye we are getting history from props
    // addEmployee(){
    //     this.props.history.push('/add-employee');
    // }

    //this methode return html
    render() {
        return (
            <div>
               <h2 className='text-center'>Employee List</h2> 
               <div className='row'>
                {/* <button className='btn btn-primary' >Add Employee</button> */}
                <Link to='/add-employee' className='btn btn-primary'> Add Employee </Link>
                <table className='table table-striped table-bordered'>
                    <thead>
                        <tr>
                            <th>Employee First Name</th>
                            <th>Employee last Name</th>
                            <th>Employee Email Id</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.employees.map(
                                employees => 
                                <tr key = {employees.id}>
                                    <td>{employees.firstName}</td>
                                    <td>{employees.lastName}</td>
                                    <td>{employees.emailId}</td>
                                    <td>
                                        {/* <button onClick={ () => this.editEmployee(employees.id)} className='btn btn-info'>update</button> */}
                                        <Link className="btn btn-info" to={`/update-employee/${employees.id}`} >Update</Link>
                                        <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEmployee(employees.id)} className="btn btn-danger">Delete </button>

                                    </td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
               </div>
            </div>
        );
    }
}

export default ListEmployeeComponent;
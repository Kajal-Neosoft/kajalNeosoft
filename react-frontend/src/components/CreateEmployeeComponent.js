import React, { Component } from 'react';
import { Link, Navigate } from 'react-router-dom';
import EmployeeService from '../service/EmployeeService';


class CreateEmployeeComponent extends Component {

    constructor(props){
        super(props)

        this.state = {
            //in this property we will get the data
           firstName:'',
           lastName:'',
           emailId:'',
           registrationsuccessful:false
        }


            this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
            this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
            this.changeEmailIdHandler = this.changeEmailIdHandler.bind(this);
            this.saveEmployee = this.saveEmployee.bind(this);

       
    }

    saveEmployee= (e) => {
        e.preventDefault();
        let employee = {firstName:this.state.firstName, lastName:this.state.lastName, emailId:this.state.emailId};
        console.log('employee => '+JSON.stringify(employee));

        EmployeeService.createEmployee(employee).then(res => {
            console.log('Response:', res.data);

            this.setState({registrationsuccessful: true});

            // <Link to ='/'></Link>

        });

    }

    changeFirstNameHandler(event)
    {
            this.setState({firstName: event.target.value});
    }
    changeLastNameHandler(event)
    {
        this.setState({lastName: event.target.value});
    }
    changeEmailIdHandler(event)
    {
        this.setState({emailId:event.target.value});
    }




    render() {

        if(this.state.registrationsuccessful)
        {
            return <Navigate to='/' />
        }

        return (
            <div>
                <div className='container'>
                    <div className='row'>
                        <div className='card col-md-6 offset-md-3 offset-md-3'>
                            <h3 className='text-center'>Add Employee</h3>
                               <div className='card-body'>
                                    <form>
                                        <div className='form-group'>
                                            <label>Fisrt Name</label>
                                            <input placeholder='First Name' name='fisrtName' className='form-control' value={this.state.firstName}
                                             onChange={this.changeFirstNameHandler}></input>
                                        </div>
                                        <div className='form-group'>
                                            <label>Last Name</label>
                                            <input placeholder='Last Name' name='lasttName' className='form-control' value={this.state.lastName}
                                             onChange={this.changeLastNameHandler}></input>
                                        </div>
                                        <div className='form-group'>
                                            <label>Email Id</label>
                                            <input placeholder='Email Id' name='emailId' className='form-control' value={this.state.emailId}
                                             onChange={this.changeEmailIdHandler}></input>
                                        </div>

                                        <button className='btn btn-success' onClick={this.saveEmployee} style={{marginTop:'20px'}}>save</button>
                                        {/* <button className='btn btn-danger' onClick={this.cancel.bind(this)} style={{marginLeft: '10px'}}Cancel></button> */}
                                        <Link to='/' className='btn btn-primary' style={{marginLeft: '10px', marginTop: '20px'}}>Cancel</Link>
                                    </form>

                            
                               </div>

                        </div>

                    </div>

                 </div>
            </div>
        );
    }
}

export default CreateEmployeeComponent;
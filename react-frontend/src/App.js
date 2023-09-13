import logo from './logo.svg';
import './App.css';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import {Routes, Route } from 'react-router-dom';
import CreateEmployeeComponent from './components/CreateEmployeeComponent';
import UpdateEmpoyeeComponent from './components/UpdateEmployeeComponent';
import UpdateEmployeeComponent from './components/UpdateEmployeeComponent';

function App() {
  return (
    <div>
     
      <HeaderComponent></HeaderComponent>
      <div className="container">
        <Routes>
          <Route path="/" exact element={<ListEmployeeComponent/>}></Route>
          <Route path="/add-employee" element={<CreateEmployeeComponent/>}></Route>
          <Route path="/update-employee/:id" element={<UpdateEmployeeComponent />}></Route>

        </Routes>
      </div>
      <FooterComponent></FooterComponent>
     
    </div>
  );
}

export default App;

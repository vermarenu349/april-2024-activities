import React, { useState } from 'react';
import { useNavigate, useParams } from "react-router-dom";
import axios from 'axios';


export function Registration() {
let [firstname,setName] = useState('');
let [lastname,setLastName] = useState('');
let [phone,setPhone] = useState('');
let [email_id,setEmail_id] = useState('');
let [pan,setPan] = useState('');
let [password,setPassword] = useState('');


let URL ='http://localhost:8080/loanapp/register';
let [customer,setCustomer]=useState('');
let navigate = useNavigate();

let handleSubmit = (e) => {
    e.preventDefault(); //It prevents reloading the browser after submitting
    axios.post(URL,{"firstname":firstname,"lastname":lastname,"phone":phone,"email_id":email_id,"pan":pan,"password":password})
    .then(response =>navigate(`/login`))
    .catch(error =>console.log(error));
    alert('check console')
}

  return (
    <div className="container">
    <div className="row justify-content-center mt-5">
      <div className="col-md-6">
        <div className="card">
          <div className="card-header">
            <h3 className="card-title text-center">SIGN UP</h3>
          </div>
          <div className="card-body">
            <form onSubmit={handleSubmit}>
              <div className="mb-3">
                <label htmlFor="first Name" className="form-label">First Name</label>
                <input type="text" className="form-control" onChange={e=>setName((e).target.value)} id="firstName" name="" placeholder="Enter First Name" />
              </div>
              <div className="mb-3">
                <label htmlFor="Last Name" className="form-label">Last Name</label>
                <input type="text" className="form-control" onChange={e=>setLastName((e).target.value)} id="lastName" name="" placeholder="Enter Last Name" />
              </div>
              <div className="mb-3">
                <label htmlFor="EmailId" className="form-label">Email ID</label>
                <input type="text" className="form-control" onChange={e=>setEmail_id((e).target.value)} id="email" name="" placeholder="Enter Email ID" />
              </div>
              <div className="mb-3">
                <label htmlFor="pan" className="form-label">PAN Number</label>
                <input type="text" className="form-control" onChange={e=>setPan((e).target.value)} id="pan" name="" placeholder="Enter PAN Number" />
              </div>
              <div className="mb-3">
                <label htmlFor="phone" className="form-label">Phone</label>
                <input type="text" className="form-control" onChange={e=>setPhone((e).target.value)} id="phone" name="" placeholder="Enter Phone NUmber" />
              </div>
              <div className="mb-3">
                <label htmlFor="password" className="form-label">Password</label>
                <input type="password" className="form-control" onChange={e=>setPassword((e).target.value)} id="password" name="" placeholder="Enter password" />
              </div>
              <button type="submit" className="btn btn-primary w-100">Register</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  );
};



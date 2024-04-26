import React,{ useState,useContext } from 'react';
import { useNavigate, useParams } from "react-router-dom";
import axios from 'axios';
import GlobalContext from './GlobalContext';


export function Login() {
const { globalVar, setGlobalVar } = useContext(GlobalContext);
let [email,setEmail_id] = useState('');
let [password,setPassword] = useState('');


let URL ='http://localhost:8080/loanapp/login';
let [customer,setCustomer]=useState('');
let navigate = useNavigate();

let handleSubmit = (e) => {
    setGlobalVar(email);
    console.log(globalVar + "  email :: " + email);
    e.preventDefault(); //It prevents reloading the browser after submitting
    axios.post(URL,null,{params:{"email":email, "password":password}})
    .then(response =>navigate(`/loans`))
    .catch(error =>console.log(error));
    alert('check console')
}

  return (
    <div className="container">
      <div className="row justify-content-center mt-5">
        <div className="col-md-6">
          <div className="card">
            <div className="card-header">
              <h3 className="card-title text-center">Login</h3>
            </div>
            <div className="card-body">
              <form onSubmit={handleSubmit}>
                <div className="mb-3">
                  <label htmlFor="username" className="form-label">Email</label>
                  <input type="text" className="form-control" name="email" onChange={e=>setEmail_id((e).target.value)} id="email" placeholder="Enter Email" />
                </div>
                <div className="mb-3">
                  <label htmlFor="password" className="form-label">Password</label>
                  <input type="password" className="form-control" name="password" onChange={e=>setPassword((e).target.value)} id="password" placeholder="Enter password" />
                </div>
                <button type="submit" className="btn btn-primary w-100">Login</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

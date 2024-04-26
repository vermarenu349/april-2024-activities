import React,{ useState, useContext } from 'react';
import { useNavigate, useParams } from "react-router-dom";
import GlobalContext from './GlobalContext';

import axios from 'axios';

export function Loan(){
    const { globalVar, setGlobalVar } = useContext(GlobalContext);
    let[custId, setCustId] = useState(0);
    let navigate = useNavigate();
    let getId = (e, index) => {
        e.preventDefault(); //It prevents reloading the browser after submitting
        axios.post('http://localhost:8080/loanapp/custId',null, {params:{"email":globalVar}})
        .then(response => setCustId(response.data))
        .catch(error =>console.log(error));
      insertdata(e,list[index].loan_id);
     console.log(`Loan Id:" + ${list[index].loan_id} + " index: " + ${index}`);
    }
    let insertdata = (e,id) => {
        e.preventDefault();
        console.log("loan id :: " + id  + " cust id: " + custId);
        axios.post('http://localhost:8080/loanapp/loanEntry',{"customer_id":custId,"loan_id":id,"status":"Pending"})
        .then(response =>navigate(`/loanapp/${custId}`))
        .catch(error =>console.log(error));
        setGlobalVar(id);
    }

    let [list,setList] = useState([]);
    let URL ='http://localhost:8080/loanapp/loans';
    axios.get(URL)
    .then(response =>setList(response.data))
    return (
        <div>
        <h2>List of Loans</h2>
      
        <table className='table'>
            <thead>
            <tr>
                <th>Loan ID</th>
                <th>Loan Applied</th>
                <th></th>
            </tr>
            </thead>
            {list.map((profile,index)=>
            <tr key={index}>
                <td>{profile.loan_id}</td>
                <td>{profile.loan_type}</td>
                <td><button className='btn btn-primary' onClick={(event) => getId(event,index)}>Take Loan</button></td>
                </tr>
                )}
            <tbody>

            </tbody>
        </table>
        </div>
    )
}
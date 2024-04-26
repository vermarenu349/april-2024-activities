import React,{ useState,useContext } from 'react';
import { useNavigate, useParams } from "react-router-dom";
import axios from 'axios';

export function LoanApp({id}){
        console.log("email " + email);
        let [list,setList] = useState([]);
        let URL =`http://localhost:8080/loanapp/loans/${id}`;
        axios.get(URL)
        .then(response =>setList(response.data))
        return (
            <div>
            <h2>List of Loans</h2>
          
            <table className='table'>
                <thead>
                <tr>
                    <th>Loan ID</th>
                    <th>Loan Status</th>
                </tr>
                </thead>
                {list.map((profile,index)=>
                <tr key={index}>
                    <td>{profile.loan_id}</td>
                    <td>{profile.status}</td>
                    </tr>
                    )}
                <tbody>
    
                </tbody>
            </table>
            </div>
        )
}
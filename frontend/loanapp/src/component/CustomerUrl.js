import { Registration } from "./registration";
import { Link, Route, Routes } from 'react-router-dom';
import React from 'react';
import { FrontPage } from "./FrontPage";
import { Login } from "./Login";
import { Loan } from "./loan";

export function CustomerUrl({loggedIn, onLogout}){
   return (<div>
      <header className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="container">
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
             <Link to="/frontPage">Home Page</Link>&nbsp;&nbsp;
             <Link to ="/loans">Loans</Link> &nbsp;&nbsp;
             <Link to ="/loansApp">Loans Applied</Link>
             <li><button onClick={onLogout}>Logout</button></li>
        </div>
      </div>
    </header>

    <Routes>
      <Route exact path='/frontPage' element= {<FrontPage/>}></Route>
      <Route path='/loans' element={<Loan/>}></Route>
    </Routes>
    </div>)
}




import { Registration } from "./registration";
import { Link, Route, Routes } from 'react-router-dom';
import React,{ useState } from 'react';
import { FrontPage } from "./FrontPage";
import { Login } from "./Login";
import { Loan } from "./loan";

export function Header(){
    const [loggedIn, setLoggedIn] = useState(false);

    const handleLogin = () => {
        setLoggedIn(true);
      };
      
   return (<div>
        <header className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="container">
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <Link to="/frontPage">Home Page</Link>&nbsp;&nbsp;
            <Link to ="/register">Register Profile</Link>
            &nbsp;&nbsp;
            <Link to ="/login">Login</Link>
            &nbsp;&nbsp;
           
          
        </div>
      </div>
    </header>

    <Routes>
      <Route exact path='/frontPage' element= {<FrontPage/>}></Route>
      <Route path='/register' element= {<Registration/>}></Route>
      <Route path='/login' element= {<Login/>}></Route>
      <Route path='/loans' element={<Loan/>}></Route>
    </Routes>
    </div>)
}




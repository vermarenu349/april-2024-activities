import './App.css';
import { FrontPage } from './component/FrontPage';
import { Header } from './component/Header';
import React,{createContext,useState} from 'react';
import GlobalContext from './component/GlobalContext';

function App() {
  const [globalVar, setGlobalVar] = useState('initialValue');

  return (
    <div className="App">
     <GlobalContext.Provider value={{ globalVar, setGlobalVar }}>
    <h1>Loan Application</h1>
   
    <Header/>
    </GlobalContext.Provider>
    </div>
  );
}

export default App;

import "./App.css";
import {React , Component } from "react";
import { BrowserRouter as Router, Route, Routes, Link} from "react-router-dom";
import {createBrowserHistory} from 'history';

import Home from "./comp/home";
import Admin from "./comp/Admin";
import Main from "./comp/main";
import Adlist from "./comp/Adlist";
import Addetails from "./comp/Addetails";
import CreateBookComponent from "./comp/books/CreateBookComponent";
import ViewBookComponent from "./comp/books/ViewBookComponent";
import UpdateBookComponent from "./comp/books/UpdateBookComponent";
import ListBookComponent from "./comp/books/ListBookComponent";

class App extends Component 
{
  render() 
  {
    const browserHistory = createBrowserHistory();
    const data = [
      {
        id: 1,
        name: "Customer Management",
      },
      {
        id: 3,
        name: "Order Management",
      },
      {
        id: 2,
        name: "Books Management",
      }];

  
  return (
    <div className="App" >
      <Router history = {browserHistory}>
        <Main/>
         <Routes  >
        <Route path = "/admin/login/2" element = {<> <ListBookComponent /> </>}></Route>
        <Route path = "/admin/login/2/add-book/:id" element = {<CreateBookComponent />}></Route>
        <Route path = "/admin/login/2/view-book/:id" element = {<ViewBookComponent />}></Route>
        <Route path = "/admin/login/2/update-book/:id" element = {<UpdateBookComponent />}></Route> 
       <Route path ="/admin/login/:id" element={<Addetails data={data}/>}></Route>
        <Route  path="/admin/login" element={<> <Adlist data={data}/></>}></Route>
        <Route  path="/" element={<> <Home  /> </>}></Route>
        <Route  path="/home" element={<> <Home  /> </>}></Route>
        <Route   path="/admin" element={<> <Admin  /></>}></Route>
        </Routes>
      </Router>
    </div>
  );
  }
}

export default App;
import {React, Component } from "react";
import {Link} from 'react-router-dom';


 export default class Main extends Component
 {
     render(){
        return(
            <div>
                <nav className="navbar navbar-default">
                    <div className="container-fluid">
                        <div className="navbar-header">
                            <a className="navbar-brand" >Try</a>
                        </div>
                        <div className="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul className="nav navbar-nav">
                                <li><Link to="/" >Home</Link></li>
                                <li><Link to="/admin" >Admin</Link></li>
                                <li><Link to="/admin/login"></Link></li>
                                <li><Link to="/admin/login/:id" ></Link></li>
                                <li><Link to="/admin/login/2" ></Link></li>
                            </ul>
                        </div>
                    </div>
                </nav>    
            </div>
        );
    }
}
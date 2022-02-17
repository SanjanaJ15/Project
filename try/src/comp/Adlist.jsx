import {React, Component} from 'react';
import {Link} from 'react-router-dom';

class Adlist extends Component 
{    
    render() 
    { 
        const ads = this.props.data.map(ad => {
            return (
                <div> 
                <Link style={{display:"block"}} to = {"/admin/login/"+ad.id}
                   className = "list-group-item"
                    key = {ad.id}>{ad.name}
                </Link>
                </div>
            );
        }
        );

        return (
            <div className="center">
                <div className='title'>
                <h1>Admin Page</h1>
                </div>
            <div className = "list-group">  {ads} </div>
           </div>
        );
    }
}
export default Adlist;
import React, { Component } from 'react'
import AxiosCalls from '../../services/Axioscalls';


import {Link} from "react-router-dom";
class ListBookComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                books: []
        }
        this.addBook = this.addBook.bind(this);
        this.editBook = this.editBook.bind(this);
        this.deleteBook = this.deleteBook.bind(this);
        this.viewBook=this.viewBook.bind(this);
    }

    deleteBook(bookid){
        AxiosCalls.deleteBook(bookid).then( res => {
            this.setState({books: this.state.books.filter(book => book.bookid !== bookid)});
        });
    }
    viewBook(bookid){
        this.props.history.push(`/admin/login/2/view-book/${bookid}`);
    }
    editBook(bookid){
        this.props.history.push(`/admin/login/2/add-book/${bookid}`);
    }

    componentDidMount(){
      
        AxiosCalls.getBooks().then((res) => {
            alert(res.data);            
            console.log(res.data);

            this.setState({ books: res.data});
        console.log(this.state.books);
        }); 
    }

    addBook(){
        this.props.history.push('/admin/login/2/add-book/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Book List</h2>
                 <div className = "row">
                 <Link to="/admin/login/2/add-book/_add">Add Book</Link>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th> Title</th>
                                    <th> Author</th>
                                    <th>Publisher</th>
                                    <th>Category</th>
                                    <th>IsAvailable</th>
                                    <th> Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.books.map(
                                        book => 
                                        <tr key = {book.bookid}>
                                             <td> {book.title} </td>   
                                             <td> {book.author}</td>
                                             <td> {book.publisher}</td> 
                                             <td> {book.category}</td>
                                             <td> {book.isAvailable}</td>
                                             <td> {book.price}</td>
                                             <td>
                                                 <button onClick={ () => this.editBook(book.bookid)} className="btn btn-info">Update Book</button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteBook(book.bookid)} className="btn btn-danger">Delete Book </button>
                                                 <button style={{marginLeft: "20px"}} onClick={ () => this.viewBook(book.bookid)} className="btn btn-info">View Book </button>
                                                 
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>
                        <button style={{marginInlineEnd: "10px"}} onClick={window.location.href="/admin/login"} className="btn btn-danger">Back To List</button>
                 </div>
            </div>
        );
    }
}

export default ListBookComponent;
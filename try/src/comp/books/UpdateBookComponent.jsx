import React, { Component } from 'react'
import AxiosCalls from '../../services/Axioscalls';

class UpdateBookComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            bookid: this.props.match.params.bookid,
            title: '',
            category:'',isAvailable:'',
            author: '', publisher:'',
            price: ''
        }
        this.changeTitleHandler = this.changeTitleHandler.bind(this);
        this.changeAuthorHandler = this.changeAuthorHandler.bind(this);
        this.changeCategoryHandler = this.changeAuthorHandler.bind(this);
        this.changePublisherHandler = this.changeAuthorHandler.bind(this);
        this.changeisAvailableHandler = this.changeAuthorHandler.bind(this);
        this.changePriceHandler = this.changeAuthorHandler.bind(this);
        this.updateBook = this.updateBook.bind(this);
    }

    componentDidMount(){
        AxiosCalls.getBookById(this.state.bookid).then( (res) =>{
            let book = res.data;
            this.setState({title: book.title,
                author: book.author,
                publisher: book.publisher,
                category: book.category,
                isAvailable: book.isAvailable,
                price : book.price,
            });
        });
    }

    updateBook = (e) => {
        e.preventDefault();
        let book = {title: this.state.title, 
            author: this.state.author, publisher:this.state.publisher, cartegory:this.state.category,
            isAvailable:this.state.isAvailable,price: this.state.price};
        console.log('book => ' + JSON.stringify(book));
        console.log('bookid => ' + JSON.stringify(this.state.bookid));
        AxiosCalls.updateBook(book, this.state.bookid).then( res => {
            this.props.history.push('/books');
        });
    }
    
    changeTitleHandler= (event) => {
        this.setState({title: event.target.value});
    }
    changeAuthorHandler= (event) => {
        this.setState({author: event.target.value});
    }
    changePublisherHandler= (event) => {
        this.setState({publisher: event.target.value});
    }
    changeCategoryHandler= (event) => {
        this.setState({category: event.target.value});
    }
    changeisAvailableHandler= (event) => {
        this.setState({isAvailable: event.target.value});
    }
    changePriceHandler= (event) => {
        this.setState({price: event.target.value});
    }

    cancel(){
        this.props.history.push('/books');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Book</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Title: </label>
                                            <input placeholder="Book Name" name="name" className="form-control" 
                                                value={this.state.title} onChange={this.changeTitleHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Author: </label>
                                            <input placeholder="Author" name="author" className="form-control" 
                                                value={this.state.author} onChange={this.changeAuthorHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Category: </label>
                                            <input placeholder="Category" name="category" className="form-control" 
                                                value={this.state.category} onChange={this.changeCategoryHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Publisher: </label>
                                            <input placeholder="Publisher" name="publisher" className="form-control" 
                                                value={this.state.publisher} onChange={this.changePublisherHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> isAvailable: </label>
                                            <input placeholder="is Available" name="isAvailable" className="form-control" 
                                                value={this.state.isAvailable} onChange={this.changeisAvailableHandler}/>
                                        </div>

                                        <div className = "form-group">
                                            <label> Price: </label>
                                            <input placeholder="Price" name="price" className="form-control" 
                                                value={this.state.price} onChange={this.changePriceHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.updateBook}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        );
    }
}

export default UpdateBookComponent
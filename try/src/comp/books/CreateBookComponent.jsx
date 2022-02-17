import React, { Component } from 'react'
import AxiosCalls from '../../services/Axioscalls';

class CreateBookComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            bookid: this.props.match.params.bookid,
            title: '',
            author: '',
            category:'',
            publisher: '',
            isAvailable:'',
            price:'',
        }
        this.changeTitleHandler = this.changeTitleHandler.bind(this);
        this.changeAuthorHandler = this.changeAuthorHandler.bind(this);
        this.changeCategoryHandler = this.changeAuthorHandler.bind(this);
        this.changePublisherHandler = this.changeAuthorHandler.bind(this);
        this.changeisAvailableHandler = this.changeAuthorHandler.bind(this);
        this.changePriceHandler = this.changeAuthorHandler.bind(this);
        this.saveOrUpdateBook = this.saveOrUpdateBook.bind(this);
    }

    componentDidMount(){
        if(this.state.bookid === '_add'){
            return
        }else{
            AxiosCalls.getBookById(this.state.bookid).then( (res) =>{
                let book = res.data;
                this.setState({title: book.title,
                    author: book.author,
                    category:book.category,
                    isAvailable:book.isAvailable,
                    publisher:book.publisher,
                    price:book.price,
                });
            });
        }        
    }
    saveOrUpdateBook = (e) => {
        e.preventDefault();
        let book = {title: this.state.title,
             author: this.state.author, 
             category:this.state.category,
              publisher:this.state.publisher, 
              isAvailable:this.state.isAvailable,
               price:this.state.price};

        console.log('book => ' + JSON.stringify(book));

        if(this.state.bookid === '_add'){
            AxiosCalls.createBook(book).then(res =>{
                this.props.history.push('/books');
            });
        }else{
            AxiosCalls.updateBooks(book, this.state.bookid).then( res => {
                this.props.history.push('/books');
            });
        }
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

    getTitle(){
        if(this.state.bookid === '_add'){
            return <h3 className="text-center">Add Book</h3>
        }else{
            return <h3 className="text-center">Update Book</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Title: </label>
                                            <input placeholder="Title" name="title" className="form-control" 
                                                value={this.state.title} onChange={this.changeTitleHandler()}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Author: </label>
                                            <input placeholder="Author" name="author" className="form-control" 
                                                value={this.state.author} onChange={this.changeAuthorHandler()}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Category: </label>
                                            <input placeholder="Category" name="category" className="form-control" 
                                                value={this.state.category} onChange={this.changeCategoryHandler()}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Publisher: </label>
                                            <input placeholder="Category" name="category" className="form-control" 
                                                value={this.state.publisher} onChange={this.changePublisherHandler()}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> isAvailabley: </label>
                                            <input placeholder="isAvailable" name="isAvailable" className="form-control" 
                                                value={this.state.isAvailable} onChange={this.changeisAvailableHandler()}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Price: </label>
                                            <input placeholder="Price" name="price" className="form-control" 
                                                value={this.state.price} onChange={this.changePriceHandler()}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateBook()}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default CreateBookComponent
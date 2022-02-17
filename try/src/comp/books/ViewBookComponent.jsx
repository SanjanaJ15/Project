import React, { Component } from 'react'
import AxiosCalls from '../../services/Axioscalls';

class ViewBookComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            bookid: this.props.match.params.bookid,
            book: {}
        }
    }

    componentDidMount(){
        AxiosCalls.getBookById(this.state.bookid).then( res => {
            this.setState({book: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Book Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Book bookid: </label>
                            <div> { this.state.book.bookid }</div>
                        </div>
                        <div className = "row">
                            <label> title: </label>
                            <div> { this.state.book.title }</div>
                        </div>
                        <div className = "row">
                            <label> Author: </label>
                            <div> { this.state.book.author }</div>
                        </div>
                        <div className = "row">
                            <label> category: </label>
                            <div> { this.state.book.category }</div>
                        </div>
                        <div className = "row">
                            <label> publisher: </label>
                            <div> { this.state.book.publisher }</div>
                        </div>
                        <div className = "row">
                            <label> isAvailable: </label>
                            <div> { this.state.book.isAvailable }</div>
                        </div>
                        <div className = "row">
                            <label> Price: </label>
                            <div> { this.state.book.price }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewBookComponent
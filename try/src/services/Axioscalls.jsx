import axios from 'axios';

const baseURL = "http://localhost:8080/api/book";

class AxiosCalls {

    getBooks(){
        return axios.get(baseURL+"/list");
    }

    createbook(book){
        return axios.post(baseURL+"/add", book);
    }

    getBookById(bookId){
        return axios.get(baseURL + "/bookid/" + bookId);
    }

    updateBook(book, bookId){
        return axios.put(baseURL + "/update/" + bookId, book);
    }

    deleteBook(bookId){
        return axios.delete(baseURL + "/delete/" + bookId);
    }
}

export default new AxiosCalls();
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;


@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/book")
@RestController
public class BookWebController {
    @Autowired
     private BookDao repo;
  
    /*
    @GetMapping("/")
    public String welcome()
    {
        return "<html><body>"
            + "<h1>WELCOME TO BOOKSET</h1>"
            + "</body></html>";
    }
  */
    
    @GetMapping("/list")
    public Iterable<Book> getAllBooks()
    {
        return repo.findAll();
    }
  
   
    
    @GetMapping("/bookid/{id}")
    public Optional<Book> getBookById(
        @PathVariable(value = "id") String id)
    {
        return repo.findById(id);
    }
    /*
    
    @GetMapping("/Cars/brand/{brand}")
    public Optional<Book> getCarBybrand(
        @PathVariable(value = "brand") String brand)
    {
        return repo.findByAuthor(brand);
    }
  */
    
    /*
    @GetMapping("/Cars/pricelessthan/{price}")
    public List<Book> findByPriceLessThan(
           @PathVariable(value = "price") double price)
    {
		return repo.findByPriceLessThan(price);
    	
    }
    */
    
    @PostMapping("/add")
  
    public Book addBook(  @RequestBody Book book)
    {
        return repo.save(book);
    }
  
    @DeleteMapping("/delete/{id}")
    public String  deleteBook(
        @PathVariable(value = "id") String id)
    {
        repo.deleteById(id);
        return "record #"+id+" Deleted sucessfully";
        
    }
  
   
    @PutMapping("/update/{id}")
    public String updateBooks(
        @RequestBody Book book,
        @PathVariable String id)
    
    {
	      repo.save(book);
	      return "contents updated";
    	
    }
    }
    
   

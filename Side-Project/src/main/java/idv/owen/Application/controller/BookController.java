package idv.owen.Application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import idv.owen.Application.model.Book;
import idv.owen.Application.dao.BookRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @SuppressWarnings("deprecation")
	@ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/v1/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}










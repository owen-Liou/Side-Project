package idv.owen.Application.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Repository;

import lombok.Data;


@Entity
public @Data class Book {
    @Id
    @GeneratedValue
    private Integer bookid;
    private String name;
    private String author;
}
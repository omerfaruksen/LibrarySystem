package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name= "category")
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private long id;
    @Column(name="name", length = 250,nullable = false)
    private String name;
    @Column(name = "description",nullable = false)
    private String description;

    @ManyToMany(mappedBy = "categories",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category(){}


}

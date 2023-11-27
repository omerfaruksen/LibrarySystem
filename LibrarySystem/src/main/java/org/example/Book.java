package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name= "book")
public class Book {
    public Book(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private long id;
    @Column(name ="book_name", nullable = false)
    private String name;
    @Column(name ="book_publication_year",nullable = false)
    private int publicationYear;
    @Column(name="book_stock",nullable = false)
    private  int stock;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="author_id")
    private Author author;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id",referencedColumnName = "id")
    private Publisher publisher;
    @OneToMany(mappedBy = "book",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<BookBorrowing> bookBorrowing;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn (name = "book_id"),
            inverseJoinColumns=@JoinColumn(name = "category_id"))
    private List<Category> categories;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<BookBorrowing> getBookBorrowing() {
        return bookBorrowing;
    }

    public void setBookBorrowing(List<BookBorrowing> bookBorrowing) {
        this.bookBorrowing = bookBorrowing;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
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

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}

package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "establisment_year",nullable = false)
    private int establishmentYear;
    @Column(name = "address",nullable = false)
    private String address;
    @OneToMany(mappedBy = "publisher",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(int establishmentYear) {
        this.establishmentYear = establishmentYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Publisher(){}
}

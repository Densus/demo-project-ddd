package com.orderbook.platform.book.domain;

import java.math.BigDecimal;
import java.util.*;


public class BookAggregate {
    private Long id;

    private String isbn;

    private Title title;

    private Description description;

    private Date published_on;

    private Publisher publisher;

    private Price org_price;

    private List<Author> authors;


    public BookAggregate(Long id, String isbn, String title, String description, Date published_on, String publisher, BigDecimal org_price, List<Author> authors) {
        this.id = id;
        this.isbn = isbn;
        this.title = new Title(title);
        this.description = new Description(description);
        this.published_on = published_on;
        this.publisher = new Publisher(publisher);
        this.org_price = new Price(org_price);
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void changeIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Title getTitle() {
        return title;
    }

    public void changeTitle(String title) {
        this.title = new Title(title);
    }

    public Description getDescription() {
        return description;
    }

    public void changeDescription(String description) {
        this.description = new Description(description);
    }

    public Date getPublished_on() {
        return published_on;
    }

    public void changePublished_on(Date published_on) {
        this.published_on = published_on;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void changePublisher(String publisher) {
        this.publisher = new Publisher(publisher);
    }

    public Price getOrg_price() {
        return org_price;
    }

    public void changeOrg_price(BigDecimal org_price) {
        this.org_price = new Price(org_price);
    }

    public List<Author> getAuthor() {
        return authors;
    }

    public void setAuthor(List<Author> authors) {
        this.authors = authors;
    }

    public static Builder builder() {
        return Builder.newInstance();
    }

    public static class Builder{
        private Long id;
        private String isbn;
        private String title;
        private String description;
        private Date published_on;
        private String publisher;
        private BigDecimal org_price;
        private List<Author> authors = new ArrayList<>();

        public Builder() {
        }

        private static Builder newInstance() {
            return new Builder();
        }

        public Builder id(Long id){
            this.id = id;
            return  this;
        }

        public Builder isbn(String isbn){
            this.isbn = isbn;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }


        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder published_on(Date published_on){
            this.published_on = published_on;
            return this;
        }

        public Builder publisher(String publisher){
            this.publisher = publisher;
            return this;
        }

        public Builder org_price(BigDecimal org_price){
            this.org_price = org_price;
            return this;
        }
        public Builder authors(List<Author> authors){
            this.authors = authors;
            return this;
        }
        public BookAggregate build() {
            return new BookAggregate(id, isbn, title, description, published_on, publisher, org_price, authors);
        }


    }
}

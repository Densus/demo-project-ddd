package com.orderbook.platform.book.infrastructure;

import com.klikcair.rs.common.util.StringUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "uid")
//    private String uid;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published_on")
    private Date publishedOn;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "org_price")
    private BigDecimal orgPrice;

//    @Column(name = "act_price")
//    private int actPrice;
//
//    @Column(name = "promotional_text")
//    private String promotionalText;
//
//    @Column(name = "image_url")
//    private String imageUrl;

    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    Set<Author> authors;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "book_id")
//    List<Review> reviews;


    public Book() {
    }

    public Book(Long id, String title, String description, Date publishedOn, String publisher, BigDecimal orgPrice) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.publishedOn = publishedOn;
        this.publisher = publisher;
        this.orgPrice = orgPrice;
//        this.authors = authors;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BigDecimal getOrgPrice() {
        return orgPrice;
    }

    public void setOrgPrice(BigDecimal orgPrice) {
        this.orgPrice = orgPrice;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void saveAuthor(String author){
        if(!StringUtils.isNullOrEmpty(author)){
            Set<Book> temp = new HashSet<>();
            temp.add(this);
            this.authors.add(new Author(author, temp));
        }
    }
}

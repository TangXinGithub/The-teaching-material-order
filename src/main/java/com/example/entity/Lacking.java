package com.example.entity;

import java.io.Serializable;
import java.util.Date;

public class Lacking implements Serializable {
    private Integer id;
    private String ISBN;
    private String bookname;
    private Double pricing;
    private String press;
    private String author;
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Double getPricing() {
        return pricing;
    }

    public void setPricing(Double pricing) {
        this.pricing = pricing;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Lacking{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", bookname='" + bookname + '\'' +
                ", pricing=" + pricing +
                ", press='" + press + '\'' +
                ", author='" + author + '\'' +
                ", count=" + count +
                '}';
    }
}

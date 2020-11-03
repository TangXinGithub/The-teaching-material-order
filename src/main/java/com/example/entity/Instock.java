package com.example.entity;

import java.io.Serializable;
import java.util.Date;

public class Instock implements Serializable {
    private Integer id;
    private String bookname;
    private Double pricing;
    private String press;
    private String author;
    private Date   press_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getPress_date() {
        return press_date;
    }

    public void setPress_date(Date press_date) {
        this.press_date = press_date;
    }

    @Override
    public String toString() {
        return "Instock{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", pricing=" + pricing +
                ", press='" + press + '\'' +
                ", author='" + author + '\'' +
                ", press_date=" + press_date +
                '}';
    }
}

package com.example.entity;

import java.io.Serializable;

public class Buying implements Serializable {
    private Integer id;
    private String ISBN;
    private String bookname;
    private Double pricing;
    private String press;
    private String author;
    private Integer count;
    private Integer pagenum;
    private String  status;
    private Integer sumtotal;

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

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSumtotal() {
        return sumtotal;
    }

    public void setSumtotal(Integer sumtotal) {
        this.sumtotal = sumtotal;
    }

    @Override
    public String toString() {
        return "Buying{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", bookname='" + bookname + '\'' +
                ", pricing=" + pricing +
                ", press='" + press + '\'' +
                ", author='" + author + '\'' +
                ", count=" + count +
                ", pagenum=" + pagenum +
                ", status='" + status + '\'' +
                ", sumtotal=" + sumtotal +
                '}';
    }
}

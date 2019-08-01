package com.tsv.diz.model;

import javax.persistence.*;

@Entity
public class SavedAd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String price;
    private String city;
    private String img;
    private String link;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public SavedAd(){

    }

    public SavedAd(String title, String price, String city, String img, String link) {
        this.title = title;
        this.price = price;
        this.city = city;
        this.img = img;
        this.link = link;
    }

    public SavedAd(String title, String price, String city, String img, String link, User user) {
        this.title = title;
        this.price = price;
        this.city = city;
        this.img = img;
        this.link = link;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

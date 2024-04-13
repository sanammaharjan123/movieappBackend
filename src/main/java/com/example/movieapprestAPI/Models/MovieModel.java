package com.example.movieapprestAPI.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
public class MovieModel {

    @Id
    private String id;
    private String title;
    private String price;
    private String synopsis;
    private String previewImg;
    private String titleImg;
    private String rentPrice;
    private String purchasePrice;
    private boolean featured;

    // Constructors, getters, and setters
    public MovieModel() {
    }

    public MovieModel(String title, String price, String synopsis, String smallPoster, String largePoster, String rentPrice, String purchasePrice, boolean featured) {
        this.title = title;
        this.price = price;
        this.synopsis = synopsis;
        this.previewImg = previewImg;
        this.titleImg = titleImg;

        this.rentPrice = rentPrice;
        this.purchasePrice = purchasePrice;
        this.featured = featured;
    }

    // Getters and setters...
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getPreviewImg() {
        return previewImg;
    }

    public void setPreviewImg(String smallPoster) {
        this.previewImg = previewImg;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImgitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    public String getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(String rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }
}


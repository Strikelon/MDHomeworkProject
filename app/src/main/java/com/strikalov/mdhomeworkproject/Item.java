package com.strikalov.mdhomeworkproject;

public class Item {

    private Picture picture;
    private String description;

    public Item(Picture picture, String description){
        this.picture = picture;
        this.description = description;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

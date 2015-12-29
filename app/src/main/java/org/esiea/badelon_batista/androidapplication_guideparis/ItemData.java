package org.esiea.badelon_batista.androidapplication_guideparis;


public class ItemData {


    private String title;
    private int imageUrl;

    public ItemData(String title,int imageUrl){

        this.title = title;
        this.imageUrl = imageUrl;
    }
    // getters & setters
    public String getTitle(){
        return title;
    }

    public int getImageUrl(){
        return imageUrl;


    }
}
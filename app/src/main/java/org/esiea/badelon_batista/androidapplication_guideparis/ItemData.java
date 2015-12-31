package org.esiea.badelon_batista.androidapplication_guideparis;


public class ItemData {


    private String title;
    private String imageUrl;
    private String descr;

    public ItemData(String title,String imageUrl,String description){

        this.title = title;
        this.imageUrl = imageUrl;
        this.descr = description;
    }
    // getters & setters
    public String getTitle(){
        return title;
    }

    public String getImageUrl(){
        return imageUrl;


    }

    public String getDescr() {
        return descr;
    }
}
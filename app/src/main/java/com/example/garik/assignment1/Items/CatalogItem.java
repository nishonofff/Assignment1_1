package com.example.garik.assignment1.Items;

/**
 * Created by nishonofff on 03.08.2018.
 */

public class CatalogItem {
    private String name;
    private String description;
    private int image;



    /**
     * Constructor of  CatalogItem class, instantiates a new Catalog item.
     * @param name
     * @param description
     * @param image
     */
    public CatalogItem(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image=image;
    }


    /**
     * @return CatalogItem name as a String
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return CatalogItem description as a String
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * @return CatalogItem image resource id as a int
     */
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

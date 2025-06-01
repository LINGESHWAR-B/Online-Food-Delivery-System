package com.examly.entity;

public class MenuItem {
    private int itemId;
    private int restaurantId;
    private String name;
    private double price;
    private String description;
    private int available;

    public MenuItem(int restaurantId, String name, double price, String description, int available){
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.available = available;
    }

    public void setItemId(int itemId){
        this.itemId = itemId;
    }

    public void setRestaurantId(int restaurantId){
        this.restaurantId = restaurantId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setAvailable(int available){
        this.available = available;
    }


    public int getItemId(){
        return itemId;
    }

    public int getRestaurantId(){
        return restaurantId;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public String getDescription(){
        return description;
    }

    public int getAvailable(){
        return available;
    }
}

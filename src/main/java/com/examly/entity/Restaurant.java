package com.examly.entity;

public class Restaurant {
    private int restaurantId;
    private String name;
    private String address;
    private String cuisineType;
    private String contactNumber;

    public Restaurant(int restaurantId, String name, String address, String cuisineType, String contactNumber){
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
        this.cuisineType = cuisineType;
        this.contactNumber = contactNumber;
    }

    public Restaurant(String name, String address, String cuisineType, String contactNumber){
        this.name = name;
        this.address = address;
        this.cuisineType = cuisineType;
        this.contactNumber = contactNumber;
    }

    public int getRestaurantId(){
        return restaurantId;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getCuisineType(){
        return cuisineType;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public void setRestaurantId(int restaurantId){
        this.restaurantId = restaurantId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setCuisineType(String cuisineType){
        this.cuisineType = cuisineType;
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }
}

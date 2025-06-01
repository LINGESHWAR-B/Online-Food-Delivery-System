package com.examly.entity;

public class Order {
    private int orderId;
    private int customerId;
    private int restaurantId;
    private String orderStatus;
    private double totalPrice;
    private String deliveryAddress;

    public Order(int customerId, int restaurantId, String orderStatus, double totalPrice, String deliveryAddress){
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.deliveryAddress = deliveryAddress;
    }

    public Order(int orderId,int customerId, int restaurantId, String orderStatus, double totalPrice, String deliveryAddress){
        this.orderId = orderId;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.deliveryAddress = deliveryAddress;
    }

    public void setOrderId(int orderId){
        this.orderId = orderId;
    }

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }

    public void setRestaurantId(int restaurantId){
        this.restaurantId = restaurantId;
    }

    public void setOrderStatus(String orderStatus){
        this.orderStatus = orderStatus;
    }

    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }

    public void setDeliveryAddress(String deliveryAddress){
        this.deliveryAddress = deliveryAddress;
    }


    public int getOrderId(){
        return orderId;
    }

    public int getCustomerId(){
        return customerId;
    }

    public int getRestaurantId(){
        return restaurantId;
    }

    public String getOrderStatus(){
        return orderStatus;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public String getDeliveryAddress(){
        return deliveryAddress;
    }
}

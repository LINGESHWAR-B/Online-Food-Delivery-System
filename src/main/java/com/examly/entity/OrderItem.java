package com.examly.entity;

public class OrderItem {
    private int orderId;
    private int itemId;
    private int quantity;

    public OrderItem(int orderId, int itemId, int quantity){
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public int getOrderId(){
        return orderId;
    }

    public int getItemId(){
        return itemId;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setOrderId(int orderId){
        this.orderId = orderId;
    }

    public void setItemId(int itemId){
        this.itemId = itemId;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}

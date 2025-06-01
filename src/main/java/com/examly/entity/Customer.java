package com.examly.entity;

public class Customer {
    private int customerId;
    private String name;
    private String email;
    private String phone;
    private String pass;

    public Customer(String name, String email, String phone, String pass){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
    }

    public Customer(int customerId,String name, String email, String phone, String pass){
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
    }

    public int getCustomerId(){
        return customerId;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

    public String getPass(){
        return pass;
    }

    public void setcutomerId(int customerId){
        this.customerId = customerId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setPass(String pass){
        this.pass = pass;
    }
}

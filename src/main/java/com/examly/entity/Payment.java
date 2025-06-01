package com.examly.entity;
import java.util.Date;
public class Payment {
    private int paymentId;
    private int orderId;
    private Date paymentDate;
    private String paymentStatus;
    private double amountPaid;

    public Payment(int paymentId, int orderId, Date paymentDate, String paymentStatus, double amountPaid){
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
        this.amountPaid = amountPaid;
    }

    public int getPaymentId(){
        return paymentId;
    }

    public int getOrderId(){
        return orderId;
    }

    public Date getPaymentDate(){
        return paymentDate;
    }

    public String getPaymentStatus(){
        return paymentStatus;
    }

    public double getAmountPaid(){
        return amountPaid;
    }

    public void setPaymentId(int paymentId){
        this.paymentId = paymentId;
    }

    public void setOrderId(int orderId){
        this.orderId = orderId;
    }

    public void setPaymentDate(Date paymentDate){
        this.paymentDate = paymentDate;
    }

    public void setPaymentStatus(String paymentStatus){
        this.paymentStatus = paymentStatus;
    }

    public void setAmountPaid(double amountPaid){
        this.amountPaid = amountPaid;
    }
}

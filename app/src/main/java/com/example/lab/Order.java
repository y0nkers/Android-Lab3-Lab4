package com.example.lab;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Order implements Serializable {
    private String processor_, videocard_, motherboard_;
    private boolean windows_;
    Date date_;

    public Order(String processor, String videocard, String motherboard, boolean windows, Date orderDate) {
        processor_ = processor;
        videocard_ = videocard;
        motherboard_ = motherboard;
        windows_ = windows;
        date_ = orderDate;
    }

    public Order() {
        processor_ = "DEFAULT";
        videocard_ = "DEFAULT";
        motherboard_ = "DEFAULT";
        windows_ = false;
        date_ = Calendar.getInstance().getTime();
    }
    
    public String getProcessor() {
        return processor_;
    }

    public void setProcessor(String processor) {
        this.processor_ = processor;
    }

    public String getVideocard() {
        return videocard_;
    }

    public void setVideocard(String videocard) {
        this.videocard_ = videocard;
    }

    public String getMotherboard() {
        return motherboard_;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard_ = motherboard;
    }

    public boolean isWindows() {
        return windows_;
    }

    public void setWindows(boolean windows) {
        this.windows_ = windows;
    }

    public void setOrderDate(Date orderDate) { date_ = orderDate;}

    public Date getOrderDate() { return date_; }

    @Override
    public String toString() {
        return "Order{" +
                "processor_='" + processor_ + '\'' +
                ", videocard_='" + videocard_ + '\'' +
                ", motherboard_='" + motherboard_ + '\'' +
                ", windows_=" + windows_ +
                ", date_=" + date_ +
                '}';
    }
}

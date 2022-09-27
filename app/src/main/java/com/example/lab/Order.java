package com.example.lab;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Order implements Serializable {
    private String processor_, videocard_, motherboard_;
    private boolean windows_;
    private int processorPrice_, videocardPrice_, motherboardPrice_, windowsPrice_;
    private Date date_;

    public Order(String processor_, String videocard_, String motherboard_, boolean windows_, int processorPrice_, int videocardPrice_, int motherboardPrice_, int windowsPrice_, Date date_) {
        this.processor_ = processor_;
        this.videocard_ = videocard_;
        this.motherboard_ = motherboard_;
        this.windows_ = windows_;
        this.processorPrice_ = processorPrice_;
        this.videocardPrice_ = videocardPrice_;
        this.motherboardPrice_ = motherboardPrice_;
        this.windowsPrice_ = windowsPrice_;
        this.date_ = date_;
    }

    public Order() {
        processor_ = "DEFAULT";
        videocard_ = "DEFAULT";
        motherboard_ = "DEFAULT";
        windows_ = false;
        processorPrice_ = 0;
        videocardPrice_ = 0;
        motherboardPrice_ = 0;
        windowsPrice_ = 0;
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

    public int getProcessorPrice() { return processorPrice_; }

    public void setProcessorPrice(int processorPrice_) { this.processorPrice_ = processorPrice_; }

    public int getVideocardPrice() { return videocardPrice_; }

    public void setVideocardPrice(int videocardPrice_) { this.videocardPrice_ = videocardPrice_; }

    public int getMotherboardPrice() { return motherboardPrice_; }

    public void setMotherboardPrice(int motherboardPrice_) { this.motherboardPrice_ = motherboardPrice_; }

    public int getWindowsPrice() { return windowsPrice_; }

    public void setWindowsPrice(int windowsPrice_) { this.windowsPrice_ = windowsPrice_; }

    @Override
    public String toString() {
        return "Order{" +
                "processor_='" + processor_ + '\'' +
                ", videocard_='" + videocard_ + '\'' +
                ", motherboard_='" + motherboard_ + '\'' +
                ", windows_=" + windows_ +
                ", processorPrice_=" + processorPrice_ +
                ", videocardPrice_=" + videocardPrice_ +
                ", motherboardPrice_=" + motherboardPrice_ +
                ", windowsPrice_=" + windowsPrice_ +
                ", date_=" + date_ +
                '}';
    }
}

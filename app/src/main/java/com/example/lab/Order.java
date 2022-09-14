package com.example.lab;

import java.io.Serializable;

public class Order implements Serializable {
    private String processor_, videocard_, motherboard_;
    private boolean windows_;

    public Order(String processor, String videocard, String motherboard, boolean windows) {
        processor_ = processor;
        videocard_ = videocard;
        motherboard_ = motherboard;
        windows_ = windows;
    }

    public Order() {
        processor_ = "DEFAULT";
        videocard_ = "DEFAULT";
        motherboard_ = "DEFAULT";
        windows_ = false;
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

    @Override
    public String toString() {
        return "Order{" +
                "processor=" + processor_ +
                ", videocard=" + videocard_ +
                ", motherboard=" + motherboard_ +
                ", windows=" + windows_ +
                '}';
    }
}

package com.OBSS.Week3.Annotation;

import java.io.Serializable;

public class Bean implements Serializable {
    private String name;
    private double price;
    private int time;

    public Bean(){
        name = "";
        price = 0;
        time = 0;
    }

    public Bean(String name, double price, int time) {
        this.name = name;
        this.price = price;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

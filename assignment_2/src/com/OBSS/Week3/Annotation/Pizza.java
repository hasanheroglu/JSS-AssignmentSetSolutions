package com.OBSS.Week3.Annotation;

@Food(price = 22.5)
public class Pizza extends Dish{

    public Pizza(){
        System.out.println("Pizza!");
    }

    @Time(takes = 10)
    public void Prepare(){
    }

    @Time(takes = 20)
    public void Cook(){
    }

    @Time(takes = 15)
    public void Send(){
    }
}

package com.OBSS.Week3.Annotation;

@Food(price = 30)
public class Sushi extends Dish{

    public Sushi(){
        System.out.println("Sushi!");
    }

    @Time(takes = 30)
    public void Prepare(){
    }

    @Time()
    public void Cook(){
    }

    @Time(takes = 20)
    public void Send(){
    }
}

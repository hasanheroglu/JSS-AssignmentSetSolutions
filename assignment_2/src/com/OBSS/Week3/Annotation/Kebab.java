package com.OBSS.Week3.Annotation;

@Food(price = 12.5)
public class Kebab extends Dish {

    public Kebab(){
        System.out.println("Kebab!");
    }

    @Time(takes = 12)
    public void Prepare(){
    }

    @Time(takes = 20)
    public void Cook(){
    }

    @Time(takes = 10)
    public void Send(){
    }


}

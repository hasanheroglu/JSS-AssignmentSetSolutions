package com.OBSS.Week3.Annotation;

import java.io.Serializable;

public abstract class Dish implements Serializable {
    public abstract void Prepare();
    public abstract void Cook();
    public abstract void Send();

}

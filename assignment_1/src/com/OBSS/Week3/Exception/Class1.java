package com.OBSS.Week3.Exception;

public class Class1 {
    public static void Call(){
        try {
            int x = 1/0;
        } catch (Exception e){
            throw new CustomException(e);
        }
    }
}

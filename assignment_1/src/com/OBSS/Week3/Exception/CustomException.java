package com.OBSS.Week3.Exception;

public class CustomException extends RuntimeException{

    CustomException(){
        super.printStackTrace();
    }

    CustomException(Exception e){
        super(e.getStackTrace().toString(), e);
        //super.printStackTrace();
    }
}

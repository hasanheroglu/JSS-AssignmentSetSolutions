package com.OBSS.Week3.Exception;

import org.apache.log4j.Logger;

public class Class3 {

    private static Logger logger = Logger.getLogger(Class3.class.getName());

    public static void Call(){

        try {
            Class2.Call();
        } catch (CustomException ex){
            ex.printStackTrace();
            logger.debug("OMG Exception!", ex);
        }
    }
}

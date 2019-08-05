package com.OBSS.Week3.Annotation;


import java.beans.JavaBean;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Restaurant {
    public static void main(String[] args) {

        String classpath = "out/production/assignment_2/com/OBSS/Week3/Annotation/";
        String packageName = "com.OBSS.Week3.Annotation.";
        File file = new File(classpath);

        List<Class> classes = new ArrayList<Class>();
        List<Bean> dishes = new ArrayList<Bean>();

        for(File f: file.listFiles()){
            if(f.isDirectory()){
            } else{
                if(f.getName().endsWith(".class")){
                    String className = f.getName().replace(".class", "");

                    try{
                        classes.add(Class.forName(packageName+className));
                    } catch (ClassNotFoundException e){
                        e.printStackTrace();
                    }
                }
            }
        }

        for(Class clazz: classes){
            if(clazz.isAnnotationPresent(Food.class)){
                String name = clazz.getName();
                double price = ((Food) clazz.getAnnotation(Food.class)).price();
                System.out.println(clazz.getName() + " is a food!");
                int time = 0;
                for(Method m: clazz.getDeclaredMethods()){
                    if(m.isAnnotationPresent(Time.class)){
                        time += m.getAnnotation(Time.class).takes();
                    }
                }
                Bean bean = new Bean(name, price, time);
                dishes.add(bean);
            }
        }
    }


}

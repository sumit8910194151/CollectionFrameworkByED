package com.learn.collectionFramework.listPackage.vectorexplanation;

import java.util.ArrayList;
import java.util.Vector;

public class VectorDemo {
    /*
    * Part of java.util package
    * one of the legacy class
    * introduced in jdk1.0
    * synchronized and thread safe all the meythod are synchronized
    * No its part of collection frame owrk
    * Howevever due to synchronization overhead, it is not recommended instead we use modern alternatives like ArrayList in single thread scenario
    * used in multithreaded scenarios where thread safety is a concern
    * when currecnt capapcity exceeded ity doubles its size
    * allows rando, access si,ilar to arraylist
    * */

    public static void main(String[] args) {
        Vector<Integer> vector=new Vector<>(3);//initial capacity>

        Vector<Integer> vector1=new Vector<>();//default initial capacity>
        System.out.println(vector1.capacity());

        Vector<Integer> vector3=new Vector<>(2,3);//initial capacity and increment by 3
        vector3.add(10);
        vector3.add(20);
        System.out.println(vector3.capacity());//capacity 2
        vector3.add(30);
        System.out.println(vector3.capacity());//capacity 2+3
        vector3.add(40);
        vector3.add(60);
        System.out.println(vector3.capacity());//cpapcity 5
        vector3.add(60);
        System.out.println(vector3.capacity());//capacity 5+3

        ArrayList<Integer> list1=new ArrayList<>();
        Thread t1=new Thread(()->{
            for(int i=0;i<1000;i++){
                list1.add(i);
            }
        });

        Thread t2=new Thread(()->{
            for(int i=0;i<1000;i++){
                list1.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(list1.size());//thus should print 2000 but its not printing because its not synchronize

        Vector<Integer> vectorSync=new Vector<>();
        Thread t3=new Thread(()->{
            for(int i=0;i<1000;i++){
                vectorSync.add(i);
            }
        });

        Thread t4=new Thread(()->{
            for(int i=0;i<1000;i++){
                vectorSync.add(i);
            }
        });

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(vectorSync.size());//this is printing 2000 as its methods are synchronized




    }

}

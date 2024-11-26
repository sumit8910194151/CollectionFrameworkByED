package com.learn.collectionFramework.listPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    /*
    *
    * An array list is a resizable array implementetaion of the List Interface. Unlike arrays in java, which
    * have a fixed size, an ArrayList can change its size dynamically as elements are added or removed.
    * This flexibility makes it a popular choice when the number of elements in a list isn't
    * known in advance
    *
    * */
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("Monday", "Tuesday");// returns a fixed size list we can not add or remove elements
        strings.add("Wednesday");// This will throw runtime exception
        strings.set(1,"Sunday");// This will work here

        List<String> daysListModifialbe=new ArrayList<>(strings);// This will allow us to modify strings
        //but it will not modufy original array

        int[] arr =new int[10];//Array definition
        ArrayList<Integer> list=new ArrayList(); //ArrayListDefinition
        list.add(10);
        list.add(20);
        list.add(80);
        System.out.println(list.size());

        for(int x: list){
            System.out.println(x);
        }

        System.out.println(list.contains(5));

        list.remove(2); // removes 2nd index
        list.add(2,50);// adds 50 at index 2
        list.set(2,50);//replaces 2nd index by 50

        /*
        * INTERNAL WORKING
        * Unlike a regular array, whiuch has a fixed size, an ArrauyList can grow and shrink
        * as elements added or removed. This dynamic resizing is achieved by creating a new array
        *  when the current array is full and copying the eelemnts to the new array.
        * List have default capacity of 10
        * size will increase by currentsSize*(3/2)+1
        *
        * */

        list.trimToSize();// it will trim the capacity to the current size

        //List<Integer> newList=List.of(1,2,3,4)
        // Available since Java 9 it returns unmodifiable List meaning you are not allowed to replace also

        // we can remove element it self also by following below
        List<String> fruits= new ArrayList<>();
        fruits.add("Apple");
        fruits.add("MAngo");
        fruits.add("Grapes");
        fruits.add("Apple");

        fruits.remove("Apple");// Here oject is passed

        List<Integer> numbers= new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(1);
        numbers.add(3);

        numbers.remove(1);// this will remove the 1st index value
        numbers.remove(Integer.valueOf(1));//This will remove the 1st occurence of 1 in List

        //Converting List to array
        Object[] array=numbers.toArray();
        Integer[] array1=numbers.toArray(new Integer[0]);//
        numbers.sort(null);// to sort in natural sorting order we are passing comparator as null


        Collections.sort(numbers);// To sort list




    }
}

package com.learn.collectionFramework.listPackage.copyonwritearraylistEd;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();//CopyOnWriteArrayList is thread safe>
        /*
        "copy on write" mean that whenever a write opertaion like adding and removing of element performed
        instead of directly modifying the existing list a new copy of the list is created and
        the modification will be applied on it
        This ensures that other threads reading th list whole it's being modified are unaffected
        * */

        //Read operation: Fast and direct. since they happen on a stable list without interference from modification
        //Write operation: A new copy of the list is created and the modification will be applied on it
        //the reference to the original list is then updated sp that subsquent reads use this new list.

        //used mainly when there is more read operation
/*
        List<String> shoppingList=new ArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");
        System.out.println(shoppingList);
        for(String item:shoppingList){
            System.out.println(item);
            if(item.equals("Eggs"))
            {
                shoppingList.add("Butter");

            }
            System.out.println("add butter while reading");
        }
        System.out.println(shoppingList);*/
        /*
        Below error will be thrown
        Exception in thread "main" java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
	at java.util.ArrayList$Itr.next(ArrayList.java:859)
	at com.learn.collectionFramework.listPackage.copyonwritearraylistEd.CopyOnWriteArrayListDemo.main(CopyOnWriteArrayListDemo.java:29)
        * */


        CopyOnWriteArrayList<String> shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");
        System.out.println(shoppingList);
        for (String item : shoppingList) {
            System.out.println(item);
            if (item.equals("Eggs")) {
                shoppingList.add("Butter");

            }
            System.out.println("add butter while reading");
        }
        System.out.println(shoppingList);

        //This will not throw any exception

        List<String> sharedList = new ArrayList<>();
        sharedList.add("Item1");
        sharedList.add("Item2");
        sharedList.add("Item3");
        Thread readerThread = new Thread(() -> {
            try {
                while (true) {
                    for (String item : sharedList) {
                        System.out.println("Reading Item " + item);
                        Thread.sleep(100);//small delay to schedule work
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(500);
                sharedList.add("Item4");
                System.out.println("Added Item4 to the list");

                Thread.sleep(500);
                sharedList.remove("Item1");
                System.out.println("Removed Item1 from the list");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        readerThread.start();
    writerThread.start();

    //Thsi will throw below exception so insteead use CopyOnWriteArrayList
        /*
        Exception in thread "Thread-0" java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
	at java.util.ArrayList$Itr.next(ArrayList.java:859)
	at com.learn.collectionFramework.listPackage.copyonwritearraylistEd.CopyOnWriteArrayListDemo.lambda$main$0(CopyOnWriteArrayListDemo.java:72)
	at java.lang.Thread.run(Thread.java:748)
        * */
    }
}

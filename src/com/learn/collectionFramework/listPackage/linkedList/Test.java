package com.learn.collectionFramework.listPackage.linkedList;

import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.get(2);//O(n)
        list.addLast(60);
        list.addFirst(0);//O(1)

        list.getFirst();
        list.getLast();
        list.removeFirst();
        list.removeLast();
        list.removeIf(x->x%2==0);




    }
}

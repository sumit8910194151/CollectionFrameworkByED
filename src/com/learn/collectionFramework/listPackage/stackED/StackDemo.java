package com.learn.collectionFramework.listPackage.stackED;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();//LIFO>

        /*
        * Stack extends vector so its also synchronized and thread safe
        * LIFO
        * Inherits from vector but is constrained by the LIFO nature
        *
        * */
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Integer a=stack.pop();

        Integer lastElement=stack.peek();//returns the top element without removing it

        stack.add(8);// add method available cause it extends vector

        System.out.println(stack);
        int aindex=stack.search(3);//returns the index of the element from the top
        System.out.println(aindex); //will return 3 cause it one based indexing
        /*
        * 8
        * 4
        * 3
        * 2
        * 1
        * */

        /*
        using linked list as stack
        * */

        LinkedList<Integer> stack1=new LinkedList<>();
        stack1.add(1);//samme as push
        stack1.add(2);
        stack1.add(3);
        stack1.add(4);
        stack1.add(5);
        stack1.removeLast();//same as pop
        stack1.getLast();//same as peek

        //Arraylist as stack
        ArrayList<Integer> stack2=new ArrayList<>();
        stack2.add(1);//same as push

        stack2.add(2);
        stack2.add(3);
        stack2.add(4);
        stack2.add(5);
        stack2.remove(stack2.size()-1);//same as pop
        stack2.get(stack2.size()-1);//same as peek

        /*
        * as tehre is no dedicated methids in arraylis so better to use linked list only
        * */


    }
}

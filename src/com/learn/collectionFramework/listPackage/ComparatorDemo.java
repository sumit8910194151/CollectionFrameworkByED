package com.learn.collectionFramework.listPackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length()-o2.length();
    }
}

class NumberAscendingComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        /*
        * returns -1 if o1 comes first and o2 after
        * return 0 if both are equal
        * return 1 if o1 is after o2
        * */
        return o1-o2;
    }
}

class NumberDescendingComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        /*
         * returns -1 if o1 comes first and o2 after
         * return 0 if both are equal
         * return 1 if o1 is after o2
         * */
        return o2-o1;
    }
}



public class ComparatorDemo {

    public static void main(String[] args) {
        List<Integer> numbers=new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(5);
        numbers.add(4);

        numbers.sort(null);//natural sorting oredr(Ascending order)

        List<String> strings=new ArrayList<>();

        strings.add("Apple");
        strings.add("Mango");
        strings.add("Banana");
        strings.add("Grapes");

        strings.sort(new StringLengthComparator());//Natural sorting order(ASCII order like library)

        System.out.println(strings);



    }
}

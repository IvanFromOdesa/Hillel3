package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        IntArrayList list = new IntArrayList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(Arrays.toString(list.toArray()));
        list.add(0, 8);
        System.out.println(Arrays.toString(list.toArray()));
        if(!list.isEmpty()){
            System.out.println("Not empty!");
        }
        list.remove(0);
        System.out.println(Arrays.toString(list.toArray()));
        list.add(6);
        list.add(9);
        list.add(6);
        System.out.println(Arrays.toString(list.toArray()));
        list.removeByValue(6);
        System.out.println(Arrays.toString(list.toArray()));
        list.subList(1, 4);
        System.out.println(list.subList(1, 4));
    }
}

package org.example.service;

import java.util.ArrayList;
import java.util.List;

public class TestingWithDataStructure {
    public static void main(String[] args) {
        List<Integer> sample = new ArrayList<>();

        sample.add(new Integer(5));
        sample.add(new Integer(2));
        sample.add(new Integer(-4));
        sample.add(new Integer(0));
        sample.add(null);
        sample.remove(2);
        sample.remove(new Integer(2));

        System.out.println("List after manipulation: ");

        for(Integer x: sample){
            System.out.println(x);
        }
        System.out.println("it is empty? " + sample.isEmpty());
        System.out.println("Current size of array: " + sample.size());
        System.out.println("return element at index 0: " + sample.get(0));
        System.out.println("get index of 0: " + sample.indexOf(0));
    }
}

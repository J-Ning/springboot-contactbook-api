package org.example.service;

import lombok.Synchronized;

interface NetworkSegmentInterface {
    //testing possible constructors:
    // NO: instance variable, private, constructors
    int a = 1;
//    int a;
    public static int b = 1;

    static String hi() { return "hi"; }

    public String networkSegment(String ip, String mask);

    abstract public int incAndGet();
}

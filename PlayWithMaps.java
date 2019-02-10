package com.company;

import java.util.HashMap;
import java.util.Map;

public class PlayWithMaps {

    public static void main(String[] args) {

        Map<String, String> myMap = new HashMap<>();

        myMap.put("Java", "What I am doing");
        myMap.put("C++" , "My first language");

        if (myMap.containsKey("Java")) {
            System.out.println("Arr has 'Java' as Key");
        }

        for (String key : myMap.keySet()) {
            System.out.println(key + ": " + myMap.get(key));
        }

    }
}

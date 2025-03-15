package org.example;

import java.util.HashMap;
import java.util.TreeMap;

public class PhoneBook {
    private final TreeMap<String, String> nameToNumber = new TreeMap<>();
    private final HashMap<String, String> numberToName = new HashMap<>();

    public int add(String name, String number) {
        if (!nameToNumber.containsKey(name)) {
            nameToNumber.put(name, number);
            numberToName.put(number, name);
        }
        return nameToNumber.size();
    }
}

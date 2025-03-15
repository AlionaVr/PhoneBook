package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class PhoneBook {
    private final TreeMap<String, String> nameToNumber = new TreeMap<>();
    private final HashMap<String, String> numberToName = new HashMap<>();

    public int add(String name, String number) {
        if (!nameToNumber.containsKey(name) && !numberToName.containsKey(number)) {
            nameToNumber.put(name, number);
            numberToName.put(number, name);
        }
        return nameToNumber.size();
    }

    public String findByNumber(String number) {
        return numberToName.get(number);
    }

    public String findByName(String name) {
        return nameToNumber.get(name);
    }

    public List<String> printAllNames() {
        List<String> names = new ArrayList<>(nameToNumber.keySet());
        for (String name : names) {
            System.out.println(name);
        }
        return names;
    }
}

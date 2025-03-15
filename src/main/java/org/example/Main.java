package org.example;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Aliona", "123");
        phoneBook.add("Boris", "456");
        phoneBook.add("Bob", "789");

        System.out.println(phoneBook.findByNumber("789")); // Bob
        System.out.println(phoneBook.findByName("Boris")); // 456

        phoneBook.printAllNames(); // Aliona, Bob, Boris
    }
}

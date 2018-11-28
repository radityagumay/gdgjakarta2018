package com.radityalabs.gdgjakarta.nullability;

public class MainJava {
    public static void main(String[] args) {
        PersonKotlin person = new PersonKotlin("raditya", "jakarta");
        System.out.print(
                "Name : " + person.getName() + "\n" +
                "Address : " + person.getAddress()
        );
    }
}

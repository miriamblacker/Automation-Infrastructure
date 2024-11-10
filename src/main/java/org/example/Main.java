package org.example;

import FileHandling.PropertiesReader;

public class Main {
    public static void main(String[] args) {
        System.out.println(PropertiesReader.getProperty("url"));
    }
}
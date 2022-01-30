package com.udemy.srp;

import java.awt.*;
import java.io.File;
import java.io.IOException;

// Demo of single responsibility principle
public class Demo {
    public static void main(String[] args) throws IOException {
        Journal j = new Journal();
        j.addEntry("I cried today");
        j.addEntry("I ate a bug");
        System.out.println(j);

        PersistEntries p = new PersistEntries();
        String filename = "../resources/journal.txt";
        p.saveToFile(j, filename, true);

        // opens file in textEdit app
        Desktop.getDesktop().edit(new File(filename));

    }
}

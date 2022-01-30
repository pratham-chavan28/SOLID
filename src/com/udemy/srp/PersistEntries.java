/***
 * To follow Single Responsibility Principle,
 * we have to create separate class to deal with
 * file handling.
 */

package com.udemy.srp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;

public class PersistEntries {
    public void saveToFile(Journal journal,
                           String filename,
                           boolean overwrite) throws FileNotFoundException {
        if(overwrite || new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(journal.toString());
            }
        }
    }
    public void load(String filename) {}
    public void load(URL url) {}
}

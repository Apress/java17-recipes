package org.java17recipes.chapter02.recipe02_13;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class HandlingErrorsEx { 
    public static void main(String[] args) {
        try {
            writeFile(new BufferedWriter(
                    new FileWriter("Easy TryWithResources")),
                    "This is easy since Java 9");
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static void writeFile(BufferedWriter writer, String text) {
        try (writer) {
            writer.write(text);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
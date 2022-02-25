package org.java17recipes.chapter08.recipe08_12;


import java.io.*;
import java.nio.file.*;

import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class Ch_8_12_ZipExample {
   public static void
   main(String[] args) {
       Ch_8_12_ZipExample example = new Ch_8_12_ZipExample();
       example.start();
   }

   private void start() {
       ZipFile file = null;
       try {
           file = new ZipFile("file.zip");
           FileSystem fileSystem = FileSystems.getDefault();
           Enumeration<? extends ZipEntry> entries = file.entries();
           String uncompressedDirectory = "uncompressed/";
           Files.createDirectory(fileSystem.getPath(uncompressedDirectory));
           while (entries.hasMoreElements()) {
               ZipEntry entry = entries.nextElement();
               if (entry.isDirectory()) {
                   System.out.println("Creating Directory:" + uncompressedDirectory + entry.getName());
                   Files.createDirectories(fileSystem.getPath(uncompressedDirectory + entry.getName()));
               } else {
                   InputStream is = file.getInputStream(entry);
                   System.out.println("File :" + entry.getName());
                   BufferedInputStream bis = new BufferedInputStream(is);

                   String uncompressedFileName = uncompressedDirectory + entry.getName();
                   Path uncompressedFilePath = fileSystem.getPath(uncompressedFileName);
                   Files.createFile(uncompressedFilePath);
                   try (FileOutputStream fileOutput = new FileOutputStream(uncompressedFileName)) {
                       while (bis.available() > 0) {
                           fileOutput.write(bis.read());
                       }
                   }
                   System.out.println("Written :" + entry.getName());
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }


   }

}

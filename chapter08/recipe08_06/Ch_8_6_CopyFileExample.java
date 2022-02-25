package org.java17recipes.chapter08.recipe08_06;

import java.io.IOException;
import java.nio.file.*;

public class Ch_8_6_CopyFileExample {

   public static void main (String[] args) {
       Ch_8_6_CopyFileExample exampleCh86 = new Ch_8_6_CopyFileExample();
       exampleCh86.copyFile();
   }

   private void copyFile() {
       FileSystem fileSystem = FileSystems.getDefault();
       System.out.println("FileSystem:" + fileSystem);
       Path sourcePath = fileSystem.getPath("file.log");
       Path targetPath = fileSystem.getPath("file2.log");
       System.out.println("Copy from "+sourcePath.toAbsolutePath().toString()+" to "+targetPath.toAbsolutePath().toString());
       try {
           Files.copy(sourcePath, targetPath);
       } catch (IOException e) {
           e.printStackTrace();
       }

   }
}


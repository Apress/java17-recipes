package org.java17recipes.chapter08.recipe08_07;


import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;


public class Ch_8_7_MoveFileExample {
   public static void main (String[] args) {
       Ch_8_7_MoveFileExample exampleCh87 = new Ch_8_7_MoveFileExample();
       exampleCh87.moveFile();
   }

   private void moveFile() {
       FileSystem fileSystem = FileSystems.getDefault();
       Path sourcePath = fileSystem.getPath("file.log");
       Path targetPath = fileSystem.getPath("file2.log");
       System.out.println("Move from "+sourcePath.toAbsolutePath().toString()+" to "+targetPath.toAbsolutePath().toString());
       try {
           Files.move(sourcePath, targetPath);
       } catch (IOException e) {
           e.printStackTrace();
       }

   }
}


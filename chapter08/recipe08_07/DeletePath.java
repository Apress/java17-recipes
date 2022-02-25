package org.java17recipes.chapter08.recipe08_07;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class DeletePath {
	public static void main (String[] args) {
	       FileSystem fileSystem = FileSystems.getDefault();
	       Path deletePath = fileSystem.getPath("deletePath");
	       System.out.println("Path to delete:"+deletePath.toAbsolutePath().toString());
	       System.out.println("Exist Path to delete? "+Files.exists(deletePath));
	       try {
	           Files.delete(deletePath);
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	   }
}

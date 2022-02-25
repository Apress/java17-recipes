package org.java17recipes.chapter02.recipe02_02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadContentsFileEx {
	public static void main(String[] args) 
	{
		Path filePathHello = Paths.get("C:/hello.txt");

		try
		{
			String contents = Files.readString(filePathHello, StandardCharsets.UTF_8);
			System.out.println(contents);
		} 
		catch (IOException err) 
		{
			err.printStackTrace();
		}
	}
}

package org.java17recipes.chapter15.recipe15_07;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.json.JSONArray;
import org.json.JSONObject;

public class BuildingJSONObject { 
	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		json.put("title", "Java 17 Recipes");
		JSONObject authorName = new JSONObject();
		authorName.put("firstName","Luciano");
		authorName.put("lastName","Manelli"); 
		json.put("author", authorName);
		JSONObject editor1 = new JSONObject();
		editor1.put("firstName", "Steve");
		editor1.put("lastName", "Anglin");
		JSONObject editor2 = new JSONObject();
		editor2.put("firstName","Matthew");
		editor2.put("lastName","Moodie"); 
		JSONArray editors = new JSONArray();
		editors.put(editor1);
		editors.put(editor2);
		json.put("editor", editors); 
		try {
			Writer jsonWriter = json.write(new FileWriter("Book.json")) ;
			jsonWriter.flush();
		} catch (IOException ex) {
			System.out.println(ex);
		}

	} 
}

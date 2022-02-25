package org.java17recipes.chapter15.recipe15_08;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParserExample {

	public static void main(String[] args) {
		JsonParserExample ex = new JsonParserExample();
		ex.parseObject();
	}

	public void parseObject() {
		String json = "{\"title\":\"Java 17 Recipes\",\"author\":{\"firstName\":\"Luciano\",\"lastName\":\"Manelli\"},\"projectCoordinator\":{\"firstName\":\"Mark\",\"lastName\":\"Powers\"},\"editor\":[{\"firstName\":\"Welmoed\",\"lastName\":\"Spahr\"},{\"firstName\":\"Steve\",\"lastName\":\"Anglin\"},{\"firstName\":\"Matthew\",\"lastName\":\"Moodie\"}],\"technicalReviewer\":[{\"firstName\":\"Manuel\",\"lastName\":\"Jordan\"}]}";
		System.out.println(json);
		JSONObject parserJson = new JSONObject(json);

		String author = parserJson.getJSONObject("author").getString("lastName");
		System.out.println("Author:"+author);

		JSONArray arr = parserJson.getJSONArray("editor");
		for (int i = 0; i < arr.length(); i++) {
			String editor = arr.getJSONObject(i).getString("lastName");
			System.out.println("editor:"+editor);
		}
	}	 
}


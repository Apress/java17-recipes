package org.java17recipes.chapter02.recipe02_16;
public class PattSwitchEx {
	public static void main(String[] args){

		//previous java 17
		Object inputObject  = 500L;
		String formattedObject ="input object is not formatted corretly!";
		if (inputObject instanceof Integer i) {
			formattedObject = String.format("Integer %d", i);
		} else if (inputObject instanceof String s) {
			formattedObject = String.format("String %s", s);
		} else if (inputObject instanceof Long l) {
			formattedObject = String.format("Long %d", l);
		} else if (inputObject instanceof Double d) {
			formattedObject = String.format("Double %f", d);
		}
		System.out.println(formattedObject);


		//java 17
		/*	 
		Object inputObject  = 500L;
		String formattedObject = switch (inputObject ) {
		    case Integer i -> String.format("int %d", i);
		    case Long l    -> String.format("long %d", l);
		    case Double d  -> String.format("double %f", d);
		    case String s  -> String.format("String %s", s);
		    default        -> inputObject .toString();
		};
		System.out.println(formattedObject);
		}
		 */
	}
}

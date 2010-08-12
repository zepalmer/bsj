package edu.jhu.cs.bsj.stdlib.metaannotations.utils;

public class NameUtilities {

	public static String lowerFirst(String fieldName) {
		return fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1);
	}


	public static String trimName(String identifier) {
		if (identifier.startsWith("get")) {
			return downcaseFirstCharacter(identifier.substring(3));
		} else {
			return identifier;
		}
	}
	
	public static String nameFromGetter(String identifier) {
		return trimName(identifier);
	}
	
	public static String nameToGetter(String identifier) {
		return "get" + upcaseFirstCharacter(identifier);
	}
	

	private static String downcaseFirstCharacter(String string) {
		return Character.toLowerCase(string.charAt(0)) + string.substring(1);
	} 
	
	private static String upcaseFirstCharacter(String string) {
		return Character.toUpperCase(string.charAt(0)) + string.substring(1);
	} 
}

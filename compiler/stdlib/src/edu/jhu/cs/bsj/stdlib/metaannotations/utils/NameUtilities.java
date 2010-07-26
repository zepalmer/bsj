package edu.jhu.cs.bsj.stdlib.metaannotations.utils;

public class NameUtilities {

	public static String lowerFirst(String fieldName) {
		return fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1);
	}

}

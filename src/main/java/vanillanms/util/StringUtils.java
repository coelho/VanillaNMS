package vanillanms.util;

import java.util.Collection;

public class StringUtils {

	public static String concat(Collection<String> strings, String seperator) {
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for(String string : strings) {
			if(first) {
				first = false;
			} else {
				builder.append(seperator);
			}
			builder.append(string);
		}
		return builder.toString();
	}
	
}

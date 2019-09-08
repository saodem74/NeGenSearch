package utils;

import java.util.Set;

/**
 * @author Harry Tran on 09/07/19.
 * @project NeGenSearch
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class StringUtils {

	public static String removeRedundantSpace(String str) {
		return org.apache.commons.lang3.StringUtils.normalizeSpace(str);

	}


	private static boolean isAllowed(char ch) {
		return  ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')
				|| Character.isDigit(ch)
				|| ch == '.' || ch == ',' || ch == ' ' || ch =='_' || ch =='-';
	}
	public static String normalized(String str) {
		String s = removeRedundantSpace(str);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); ++i) {
			if (isAllowed(s.charAt(i))) sb.append(s.charAt(i));
		}

		return filterUnusedful(sb.toString());
	}

	public static String filterUnusedful(String str) {
		int id = str.indexOf("Navigation menu Personal");
		if (id == -1) return str;
		return str.substring(0, id - 1);
	}
}

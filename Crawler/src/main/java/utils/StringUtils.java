package utils;

import java.util.HashSet;
import java.util.Set;
/**
 * @author Harry Tran on 09/07/19.
 * @project NeGenSearch
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class StringUtils {

	private static Set<String> stopwords;

	private static void initStopwords() {
		String st = FileReader.readStringFromFile("./src/main/resources/input/stopword.txt");
		String[] ss = st.split("\n");
		stopwords = new HashSet<>();
		for (String s : ss) stopwords.add(s);
	}

	private static boolean isStopword(String str) {
		if (stopwords == null) initStopwords();
		return stopwords.contains(str);
	}

	public static String removeRedundantSpace(String str) {
		return org.apache.commons.lang3.StringUtils.normalizeSpace(str);
	}


	private static boolean isAllowed(char ch) {
		return  ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z');
//				|| Character.isDigit(ch)
//				|| ch == '.' || ch == ',' || ch == ' ' || ch =='_' || ch =='-';
	}

	private static boolean isAllowedStr(String str) {
		if (str.length() <= 2) return false;
		for (int i = 0; i < str.length(); ++i)
			if (!isAllowed(str.charAt(i))) return false;
		return true;
	}
	private static String removeRedundantString(String str) {
		StringBuilder sb = new StringBuilder();
		String[] strs = str.split(" ");
		for (String s : strs) {
			if (isStopword(s)) continue;
			if (isAllowedStr(s)) sb.append(s).append(" ");
			if (sb.length() >= 1000) break;
		}
		return sb.toString();
	}
	public static String normalized(String str) {
		String s = removeRedundantSpace(str);
		s = filterUnusedful(s);
		s = removeRedundantString(s);

//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < s.length(); ++i) {
//			if (isAllowed(s.charAt(i))) sb.append(s.charAt(i));
//		}

		return s;
	}

	public static String filterUnusedful(String str) {
		int id = str.indexOf("Navigation menu Personal");
		if (id == -1) return str;
		return str.substring(0, id - 1);
	}
}

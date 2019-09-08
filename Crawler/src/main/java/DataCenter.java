import utils.FileWriter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Harry Tran on 9/8/19.
 * @project SE6362
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class DataCenter {
	static private Map<String, String> mapPageToURL = new HashMap<>();

	public static void push(String page, String url) {
		mapPageToURL.put(page, url);
	}

	public static void printOut() {
		StringBuilder sb = new StringBuilder();
		for (String s : mapPageToURL.keySet()) {
			sb.append(s).append(" ").append(mapPageToURL.get(s)).append("\n");
		}
		FileWriter.writeStringToFile(Config.MappingPageToUrl_File, sb.toString());
	}
}

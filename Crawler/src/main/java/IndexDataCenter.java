import utils.FileReader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Harry Tran on 10/21/19.
 * @project Crawler
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class IndexDataCenter {
	static private Map<String, String> mapURLtoContent = new HashMap<>();

	public static void init() {
		String data = FileReader.readStringFromFile(Config.MappingPageToUrl_File);
		String[] lines = data.split("\n");
		for (String line : lines) {
			String[] str = line.split(" ");
			String content = FileReader.readStringFromFile(str[0]);
			mapURLtoContent.put(str[1], content);
		}
	}

}

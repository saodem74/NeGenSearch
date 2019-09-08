import utils.FileReader;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Harry Tran on 09/07/19.
 * @project NeGenSearch
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class UrlController {
	private static Set<String> accepted = null;

	private static void readAcceptedURLs() {
		String lists = FileReader.readStringFromFile(Config.AcceptedUrl_File);
		String[] lines = lists.split("\n");
		accepted = new HashSet<>();
		for (String line : lines)
			if (line.length() > 0) accepted.add(line);
	}

	public static boolean isAccepted(String url) {
		if (accepted == null) readAcceptedURLs();
		for (String str : accepted)
			if (url.startsWith(str)) return true;
		return false;
	}
}

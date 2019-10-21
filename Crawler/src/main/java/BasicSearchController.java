import utils.FileReader;

import java.util.*;

/**
 * @author Harry Tran on 10/21/19.
 * @project Crawler
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BasicSearchController {
	static private Map<Integer, String> mapIDtoURL = new HashMap<>();
	static private Map<Integer, List<String>> mapIDtoContent = new HashMap<>();
	static private List<int[]> indexes = null;

	private static void init() {
		indexes = new ArrayList<>();

		String data = FileReader.readStringFromFile(Config.IndexedFile);
		String[] lines = data.split("\n");
		for (String line : lines) {
			String[] ss = line.split(" ");
			int id = Integer.parseInt(ss[0]);
			int shift = Integer.parseInt(ss[1]);
			int[] tmp = {id, shift};
			indexes.add(tmp);
		}

		data = FileReader.readStringFromFile(Config.IdToURL);
		lines = data.split("\n");
		for (String line : lines) {
			String[] ss = line.split(" ");
			mapIDtoURL.put(Integer.parseInt(ss[0]), ss[1]);
		}

		data = FileReader.readStringFromFile(Config.IdToContent);
		lines = data.split("\n");
		for (String line : lines) {
			String[] ss = line.split(" ");
			List<String> content = new ArrayList<>();
			for (int i = 1; i < ss.length; ++i)
				content.add(ss[i]);
			mapIDtoContent.put(Integer.parseInt(ss[0]), content);
		}
	}

	public static String getContentFromIndexies(int id, int shift) {
		List<String> str = mapIDtoContent.getOrDefault(id, null);
		if (str == null) return null;
		StringBuilder sb = new StringBuilder();
		for (int i = shift; i < str.size(); ++i)
			sb.append(str.get(i)).append(" ");
		for (int i = 0; i < shift; ++i)
			sb.append(str.get(i)).append(" ");
		return sb.toString();
	}

	public static List<String[]> getResultQuery(String query) {
		if (indexes == null) init();

		List<String[]> res = new ArrayList<>();
		Set<Integer> inq = new HashSet<>();

		int l = 0, r = indexes.size() - 1;
		int pos = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			String tmpStr = getContentFromIndexies(indexes.get(mid)[0], indexes.get(mid)[1]);
			if (tmpStr.startsWith(query)) {
				pos = mid;
				break;
			}
			if (tmpStr.compareToIgnoreCase(query) < 0) l = mid + 1;
			else r = mid - 1;
		}

		if (pos != -1) {
			String[] tmp = {mapIDtoURL.get(indexes.get(pos)[0]), getContentFromIndexies(indexes.get(pos)[0], indexes.get(pos)[1])};
			inq.add(indexes.get(pos)[0]);
			res.add(tmp);
			int i = pos - 1;
			while (i >= 0) {
				String tmpStr = getContentFromIndexies(indexes.get(i)[0], indexes.get(i)[1]);
				if (tmpStr.startsWith(query)) {
					if (!inq.contains(indexes.get(i)[0])) {
						String[] tmpi = {mapIDtoURL.get(indexes.get(i)[0]), getContentFromIndexies(indexes.get(i)[0], indexes.get(i)[1])};
						inq.add(indexes.get(i)[0]);
						res.add(tmpi);
					}
					--i;
				} else break;
			}

			i = pos + 1;
			while (i < indexes.size()) {
				String tmpStr = getContentFromIndexies(indexes.get(i)[0], indexes.get(i)[1]);
				if (tmpStr.startsWith(query)) {
					if (!inq.contains(indexes.get(i)[0])) {
						String[] tmpi = {mapIDtoURL.get(indexes.get(i)[0]), getContentFromIndexies(indexes.get(i)[0], indexes.get(i)[1])};
						inq.add(indexes.get(i)[0]);
						res.add(tmpi);
					}
					++i;
				} else break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		List<String[]> res = BasicSearchController.getResultQuery("programming");
		for (int i = 0; i < res.size(); ++i) {
			System.out.println(res.get(i)[0]);
			System.out.println("..." + res.get(i)[1].substring(0, 100) + "...\n");
		}
	}
}

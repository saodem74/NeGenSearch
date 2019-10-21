import utils.FileReader;
import utils.FileWriter;

import java.util.*;

/**
 * @author Harry Tran on 10/21/19.
 * @project Crawler
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class IndexDataCenter {
	static private Map<Integer, String> mapIDtoURL = new HashMap<>();
	static private Map<Integer, List<String>> mapIDtoContent = new HashMap<>();
	static private int numOfUrl = 0;
	static private List<int[]> indexes = new ArrayList<>();

	public static void init() {
		String data = FileReader.readStringFromFile(Config.MappingPageToUrl_File);
		String[] lines = data.split("\n");
		for (String line : lines) {
			String[] str = line.split(" ");
			String content = FileReader.readStringFromFile(str[0]);
			mapIDtoURL.put(numOfUrl, str[1]);

			String[] ss = content.split(" ");
			List<String> tmp = new ArrayList<>();
			for (String s : ss) tmp.add(s);
			mapIDtoContent.put(numOfUrl++, tmp);
		}
		System.out.println("#URL = " + Integer.toString(numOfUrl));
	}

	public static String getContentFromIndexies(int id, int shift) {
		List<String> str = mapIDtoContent.get(id);
		StringBuilder sb = new StringBuilder();
		for (int i = shift; i < str.size(); ++i)
			sb.append(str.get(i)).append(" ");
		for (int i = 0; i < shift; ++i)
			sb.append(str.get(i)).append(" ");
		return sb.toString();
	}

	public static void genCircularShift() {
		for (int i = 0; i < numOfUrl; ++i) {
			int maxShift = mapIDtoContent.get(i).size();
			for (int shift = 0; shift < maxShift; ++shift) {
				int[] tmp = {i, shift};
				indexes.add(tmp);
			}
		}
		Collections.sort(indexes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				String s1 = getContentFromIndexies(o1[0], o1[1]);
				String s2 = getContentFromIndexies(o2[0], o2[1]);
				return s1.compareToIgnoreCase(s2);
			}
		});
	}

	public static void storeIndexedDataToFile() {
		StringBuilder sb = new StringBuilder();
		for (int[] idx : indexes) {
			sb.append(idx[0]).append(" ").append(idx[1]).append("\n");
		}
		FileWriter.writeStringToFile(Config.IndexedFile, sb.toString());

		sb = new StringBuilder();
		for (int i = 0; i < numOfUrl; ++i) {
			String url = mapIDtoURL.getOrDefault(i, null);
			if (url == null) continue;
			sb.append(i).append(" ").append(url).append("\n");
		}
		FileWriter.writeStringToFile(Config.IdToURL, sb.toString());

		sb = new StringBuilder();
		for (int i = 0; i < numOfUrl; ++i) {
			List<String> content = mapIDtoContent.getOrDefault(i, null);
			if (content == null) continue;
			sb.append(i).append(" ");
			for (String s : content) sb.append(s).append(" ");
			sb.append("\n");
		}
		FileWriter.writeStringToFile(Config.IdToContent, sb.toString());

		sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int[] idx : indexes) {
			String s = getContentFromIndexies(idx[0], idx[1]);
			sb.append(s).append("\n");
			sb2.append(s.substring(0, 50)).append("...\n")
		}
		FileWriter.writeStringToFile(Config.FullSortedData, sb.toString());
		FileWriter.writeStringToFile(Config.FullSortedData_ShortVersion, sb2.toString());
	}
}

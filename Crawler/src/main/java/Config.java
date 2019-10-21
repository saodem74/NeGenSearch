/**
 * @author Harry Tran on 9/8/19.
 * @project SE6362
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class Config {
	public static final String AcceptedUrl_File = "./src/main/resources/input/acceptedURL";
	public static final String Stopword_File = "./src/main/resources/input/stopword.txt";

	public static final String StorageFolder =  "./src/main/resources/crawledData/";
	public static final String PageOutput = "./src/main/resources/crawledData/pages/page";
	public static final String MappingPageToUrl_File = "./src/main/resources/crawledData/mappingPageToUrl.txt";

	public static final String SeedPage = "https://en.wikipedia.org/wiki/Software_engineering";

	public static final String IndexedFile =  "./src/main/resources/indexed/SortedIndex.txt";
	public static final String IdToURL =  "./src/main/resources/indexed/IdToURL.txt";
	public static final String IdToContent =  "./src/main/resources/indexed/IdToContent.txt";
	public static final String FullSortedData =  "./src/main/resources/indexed/FullSortedData.txt";
}

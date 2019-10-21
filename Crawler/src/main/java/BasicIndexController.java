/**
 * @author Harry Tran on 10/21/19.
 * @project Crawler
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BasicIndexController {
	public static void main(String[] args) {
		IndexDataCenter.init();
		IndexDataCenter.genCircularShift();
		IndexDataCenter.storeIndexedDataToFile();
	}
}

package utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;


/**
 * @author Harry Tran on 09/07/19.
 * @project NeGenSearch
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class FileReader {
	public static String readStringFromFile(String inputFile) {
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(inputFile));
			byte[] bytes = new byte[(int) new File(inputFile).length()];
			in.read(bytes);
			in.close();
			return new String(bytes);
		}
		catch (Exception e) {
			return null;
		}
	}
}

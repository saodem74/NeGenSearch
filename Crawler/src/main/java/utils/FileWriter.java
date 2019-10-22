package utils;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * @author Harry Tran on 09/07/19.
 * @project NeGenSearch
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class FileWriter {
	public static void writeStringToFile(String outputFile, String data) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new java.io.FileWriter(outputFile));
			writer.write(data);
		}
		catch (IOException e) {
			System.out.println("Writing error <<<");
		}
		finally {
			try {
				if (writer != null)
					writer.close();
			}
			catch (IOException e) {
				System.out.println("Flie Closing error <<<");
			}
		}
	}

	public static void writeStringToEndOfFile(String outputFile, String data) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new java.io.FileWriter(outputFile, true));
			writer.write(data);
		}
		catch (IOException e) {
			System.out.println("Writing error <<<");
		}
		finally {
			try {
				if (writer != null)
					writer.close();
			}
			catch (IOException e) {
				System.out.println("Flie Closing error <<<");
			}
		}
	}
}

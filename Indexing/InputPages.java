import java.io.*;
import java.util.*;

public class InputPages {

    //Read webpage files into string line
    public String Page2Line(String filePath) {
        BufferedReader reader;
        String ReadLine = "";
        try {
            reader = new BufferedReader(new FileReader(
                    filePath));
            // read next line
            String line = reader.readLine();
            ReadLine = line.replaceAll("[\\pP\\p{Punct}]","");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ReadLine;
    }

    //Read stop word file into string line
    public String Stopword2Line(String filePath) throws FileNotFoundException {
        String stopString = "";

        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        stopString = scanner.nextLine();
        while (scanner.hasNextLine()) {
            stopString = stopString + "," + scanner.nextLine();
        }
        return stopString;
    }

    //Testing purpose (just ignore it)
    public String Test2Line(String TestPath) throws FileNotFoundException {
        File testfile = new File(TestPath);
        Scanner testscanner = new Scanner(testfile);

        String TestString = testscanner.nextLine();
        while (testscanner.hasNextLine()) {
            TestString = TestString + " " + testscanner.nextLine();
        }
        return TestString;
    }

    //Get all file listed in the webpages folder
    public List<String> GetPath(String DirPath){
        File folder = new File(DirPath);
        File[] listOfFiles = folder.listFiles();
        List<String> PathFile = new ArrayList<String>();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                PathFile.add(listOfFiles[i].getName());
            }
        }
        return PathFile;
    }
}
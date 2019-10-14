import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
public class IndexMain {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Get Data List\n");
        List<String> listOfFiles = new ArrayList<String>();
        //Get all webpages list into "listOfFiles"
        listOfFiles = new InputPages().GetPath("../Crawler/src/main/resources/crawledData/pages/"); //Get Files list for the dictionary

        System.out.println("Get All Data\n");
        List<String> LineList = new ArrayList<String>();
        //Read Each file in directory into "LiseList"
        LineList = new DataCenter().GetLineList("../Crawler/src/main/resources/crawledData/pages/");

        System.out.println("CircularShift All Data and save as index\n");
        //Do CircularShift and save into "IndexList" (Unsorted)
        List<String> IndexList = new ArrayList<String>();
        IndexList = new CircularShift().GetCircularIndex(LineList, listOfFiles);

        System.out.println("Do Sorting!!!\n");

        //Sort IndexList and save into "SortedIndex"
        List<String> SortedIndex = new ArrayList<String>();
        SortedIndex = new IndexMergeSort().Alphabetizer(LineList, listOfFiles, IndexList);

        //for (String ClassThree : SortedIndex) {
          //  System.out.println(ClassThree);
        //}

    }
}

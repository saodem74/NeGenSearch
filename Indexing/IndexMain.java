import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class IndexMain {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> listOfFiles = new ArrayList<String>();
        listOfFiles = new InputPages().GetPath("./Crawler/src/main/resources/crawledData/pages/"); //Get Files list for the dictionary

        List<String> LineList = new ArrayList<String>();
        //Read Each file in directory
        LineList = new DataCenter().GetLineList("./Crawler/src/main/resources/crawledData/pages/");

        List<String> IndexList = new ArrayList<String>();

        IndexList = new CircularShift().GetCircularIndex(LineList, listOfFiles);

        //for (String a : IndexList)
        //    System.out.println(a);
        //System.out.println(LineList.get(i).charAt(0));


        String[] ClassOne = { "Kring", "Panda", "Soliel", "Darryl", "Chan", "Matang", "Jollibee.", "Inasal" };
        String[] ClassTwo = { "Minnie", "Kitty", "Madonna", "Miley", "Zoom-zoom", "Cristine", "Bubbles", "Ara", "Rose", "Maria1", "Maria10", "Maria9" };
        String[] names = new String[ClassOne.length + ClassTwo.length];

        char[] data = new char[3];
        data[0] = 'd';
        data[1] = 'd';
        data[2] = ' ';
        data = new char[3];
        data[0] = 'e';
        data[1] = 'e';
        data[2] = ' ';
        String abc = new String(data);
        String res = "";
        String test = "ee";
        res = res.concat(abc);
        res = res.trim();
        if(res.equals(test))
            System.out.println(res);

        //System.out.println(res);

        IndexMergeSort.mergeSort(ClassOne);
        IndexMergeSort.mergeSort(ClassTwo);

        IndexMergeSort.merge(names, ClassOne, ClassTwo);

        IndexMergeSort.mergeSort(names);

        for (String ClassThree : names) {
            System.out.println(ClassThree);
        }
    }
}

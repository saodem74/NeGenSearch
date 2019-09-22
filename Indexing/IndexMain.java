import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class IndexMain {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> listOfFiles = new ArrayList<String>();
        listOfFiles = new InputPages().GetPath("./Crawler/src/main/resources/crawledData/TestPages/"); //Get Files list for the dictionary

        List<String> LineList = new ArrayList<String>();
        //Read Each file in directory
        LineList = new DataCenter().GetLineList("./Crawler/src/main/resources/crawledData/TestPages/");

        //Do CircularShift
        //List<String> IndexList = new ArrayList<String>();
        //IndexList = new CircularShift().GetCircularIndex(LineList, listOfFiles);

        String CircularTestIndex = new InputPages().Test2Line("./CircularShiftIndex.txt");
        System.out.println(CircularTestIndex);

        String[] TestIndex = CircularTestIndex.split(" ");
        for (String a : TestIndex){
            System.out.println(a);
            String [] TempNum = a.split(",");
            String IndexLine = "";
            IndexLine = new DataCenter().getLine(LineList, Integer.parseInt(TempNum[0]), Integer.parseInt(TempNum[1]));
            System.out.println(IndexLine);
        }
/*
        String[] SortedIndex = {};
        String[] RightIndex = {""};

        for (String UnSortIndex : TestIndex){
            RightIndex[0] = UnSortIndex;
            String[] names = new String[SortedIndex.length + UnSortIndex.length];
            IndexMergeSort.mergeSort(UnSortIndex);
            IndexMergeSort.merge(names, SortedIndex, UnSortIndex);
            RightIndex = {""};
        }
*/

        String[] TempOne = { "Kring", "Panda", "Soliel", "Darryl", "Chan", "Matang", "Jollibee.", "Inasal" };
        String[] TempTwo = { "Minnie", "Kitty", "Madonna", "Miley", "Zoom-zoom", "Cristine", "Bubbles", "Ara", "Rose", "Maria1", "Maria10", "Maria9" };

        List<String> ClassOne = Arrays.asList(TempOne);
        List<String> ClassTwo = Arrays.asList(TempTwo);
        List<String> names = new ArrayList<String>();

        //initial sort listArray
        for (int i=0; i< ClassOne.size()+ClassTwo.size(); i++){
            names.add("");
        }

        IndexMergeSort.mergeSort(ClassOne);
        IndexMergeSort.mergeSort(ClassTwo);

        IndexMergeSort.merge(names, ClassOne, ClassTwo);

        //IndexMergeSort.mergeSort(names);

        for (String ClassThree : names) {
            System.out.println(ClassThree);
        }
    }
}

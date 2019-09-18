import java.io.File;
import java.util.*;
public class IndexMain {
    public static void main(String[] args) {
        List<String> listOfFiles = new ArrayList<String>();
        listOfFiles = new InputPages().GetPath("./Crawler/src/main/resources/crawledData/pages/"); //Get Files list for the dictionary

        List<String> LineList = new ArrayList<String>();
        //Read Each file in directory
        LineList = new DataCenter().GetLineList("./Crawler/src/main/resources/crawledData/pages/");

        List<String> IndexList = new ArrayList<String>();
        for (int i = 0; i < LineList.size(); i++) {
            String FileNum = listOfFiles.get(i).replace("page","");
            IndexList.add(FileNum+",1");
            //System.out.println(IndexList.get(i));
            String TempLine = LineList.get(i).replaceAll("[\\pP\\p{Punct}]","");
            //String[] arrOfStr = TempLine.split(" ");
            for (int count=0; count < TempLine.length(); count++){
                if (TempLine.charAt(count) == ' '){
                    IndexList.add(FileNum+","+Integer.toString(count+2));
                }
            }

            //for (String a : IndexList)
            //    System.out.println(a);
            //System.out.println(LineList.get(i).charAt(0));
        }


        String[] ClassOne = { "Kring", "Panda", "Soliel", "Darryl", "Chan", "Matang", "Jollibee.", "Inasal" };
        String[] ClassTwo = { "Minnie", "Kitty", "Madonna", "Miley", "Zoom-zoom", "Cristine", "Bubbles", "Ara", "Rose", "Maria1", "Maria10", "Maria9" };
        String[] names = new String[ClassOne.length + ClassTwo.length];

        IndexMergeSort.mergeSort(ClassOne);
        IndexMergeSort.mergeSort(ClassTwo);

        IndexMergeSort.merge(names, ClassOne, ClassTwo);

        IndexMergeSort.mergeSort(names);

        for (String ClassThree : names) {
            System.out.println(ClassThree);
        }
    }
}

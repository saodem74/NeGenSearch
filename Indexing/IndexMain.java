import java.io.File;
import java.util.*;
public class IndexMain {
    public static void main(String[] args) {
        List<String> listOfFiles = new ArrayList<String>();
        listOfFiles = new InputPages().GetPath("./Crawler/src/main/resources/crawledData/pages/");

        String SaveLine = "";
        String FileNameString = "";
        List<String> LineList = new ArrayList<String>();
        //Read Each file in directory
        for (int i =0; i < listOfFiles.size(); i++){
            FileNameString = listOfFiles.get(i);
            SaveLine = new InputPages().Page2Line("./Crawler/src/main/resources/crawledData/pages/"+FileNameString);
            LineList.add(SaveLine); //Save Webpage Line in "LineList"
            //System.out.println(SaveLine);
        }
        //for (int i = 0; i < LineList.size(); i++)
        //   System.out.println(LineList.get(i));

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

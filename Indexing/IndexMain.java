import java.io.File;
import java.util.*;
public class IndexMain {
    public static void main(String[] args) {
        List<String> listOfFiles = new ArrayList<String>();
        listOfFiles = new InputPages().GetPath("./Crawler/src/main/resources/crawledData/pages/");

        String[] FileNameArr = new String[listOfFiles.size()];
        for (int i =0; i < listOfFiles.size(); i++)
            FileNameArr[i] = listOfFiles.get(i);
        for (String x : FileNameArr)
            System.out.print(x + "\n");

        String SaveLine = "";
        SaveLine = new InputPages().Page2Line("./Crawler/src/main/resources/crawledData/pages/page1");
        //System.out.println(SaveLine);

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

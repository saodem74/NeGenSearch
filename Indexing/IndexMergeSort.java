import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class IndexMergeSort {
    public static void mergeSort(List<String> LineList, List<String> names) {
        if (names.size() >= 2) {
            List<String> left = new ArrayList<String>();
            List<String> right = new ArrayList<String>();

            int ListIndex = 0;
            for (String a : names) {
                if (ListIndex < names.size()/2) {
                    left.add(a);
                    ListIndex = ListIndex + 1;
                }
                else{
                    right.add(a);
                    ListIndex = ListIndex + 1;
                }
            }
            mergeSort(LineList, left);
            mergeSort(LineList, right);
            merge(LineList, names, left, right);
        }
    }

    public static void merge(List<String> LineList, List<String> names, List<String> left, List<String> right) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < names.size(); i++) {
            String[] TempNum;
            String LeftLine = "";
            String RightLine = "";
            if (a < left.size()) {
                TempNum = left.get(a).split(",");
                LeftLine = new DataCenter().getLine(LineList, Integer.parseInt(TempNum[0]), Integer.parseInt(TempNum[1]));
            }
            if (b < right.size()) {
                TempNum = right.get(b).split(",");
                RightLine = new DataCenter().getLine(LineList, Integer.parseInt(TempNum[0]), Integer.parseInt(TempNum[1]));
            }
            if (b >= right.size() || (a < left.size() && LeftLine.compareToIgnoreCase(RightLine) < 0)) {
                names.set(i, left.get(a));
                a++;
            } else {
                names.set(i, right.get(b));
                b++;
            }
        }
    }

    public List<String> Alphabetizer (List<String> LineList, List<String> IndexList) throws FileNotFoundException {
        List<String> LeftIndex = new ArrayList<String>();
        List<String> RightIndex = new ArrayList<String>();
        List<String> SortedIndex = new ArrayList<String>();
        for (String UnSortIndex : IndexList){
            if (LeftIndex.isEmpty()){
                LeftIndex.add(UnSortIndex);
                SortedIndex.add("");
            }
            else{
                RightIndex.clear();
                RightIndex.add(UnSortIndex);
                SortedIndex.add("");
                IndexMergeSort.merge(LineList, SortedIndex, LeftIndex, RightIndex);
                LeftIndex.add("");
                for(int i=0; i<SortedIndex.size(); i++){
                    LeftIndex.set(i, SortedIndex.get(i));
                }
            }
        }

        PrintStream out = new PrintStream(new FileOutputStream("SortedCircularIndex.txt"));
        for (String a : SortedIndex) {
            out.print(a + '\n');
        }
        return SortedIndex;
    }
}
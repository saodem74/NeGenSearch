import java.util.*;

public class IndexMergeSort {
    public static void mergeSort(List<String> names) {
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
            mergeSort(left);
            mergeSort(right);
            merge(names, left, right);
        }
    }

    public static void merge(List<String> names, List<String> left, List<String> right) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < names.size(); i++) {
            if (b >= right.size() || (a < left.size() && left.get(a).compareToIgnoreCase(right.get(b)) < 0)) {
                names.set(i, left.get(a));
                a++;
            } else {
                names.set(i, right.get(b));
                b++;
            }
        }
    }
}
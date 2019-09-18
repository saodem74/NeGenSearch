public class IndexMain {
    public static void main(String[] args) {
        String SaveLine = "";
        SaveLine = new InputPages().Page2Line("./Crawler/src/main/resources/crawledData/pages/page1");
        System.out.println(SaveLine);
        String[] ClassOne = { "Kring", "Panda", "Soliel", "Darryl", "Chan", "Matang", "Jollibee.", "Inasal" };
        String[] ClassTwo = { "Minnie", "Kitty", "Madonna", "Miley", "Zoom-zoom", "Cristine", "Bubbles", "Ara", "Rose", "Maria123", "Maria123" };
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

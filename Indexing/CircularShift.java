import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CircularShift {
    public List<String> GetCircularIndex(List<String> LineList, List<String> listOfFiles) throws FileNotFoundException {
        String stopString = "";
        stopString = new InputPages().Stopword2Line("./Indexing/stopword.txt");
        //stopString = stopString.replaceAll("[\\pP\\p{Punct}]","");
        String[] StopArray = stopString.split(",");

        char[] TempLineWord = new char[30]; //create temp word saving parameter for possibly stop word
        int TempIndex = 0;
        int StopFlag = 0;

        List<String> IndexList = new ArrayList<String>();
        for (int i = 0; i < LineList.size(); i++) {
            String FileNum = listOfFiles.get(i).replace("page","");
            IndexList.add(FileNum+",1");
            String TempLine = LineList.get(i).replaceAll("[\\pP\\p{Punct}]","");
            //System.out.println(TempLine);
            for (int count=0; count < TempLine.length(); count++){
                if (TempLine.charAt(count) == ' '){ //Split the line by space
                    StopFlag = 0;
                    //Concate saved char into word (for compare with Stop word)
                    String ConcateWord = "";
                    String StringStop = new String(TempLineWord);//Change char array into string
                    ConcateWord = ConcateWord.concat(StringStop);//Concate the string
                    for (String StopCom : StopArray){
                        if(ConcateWord.equals(StopCom.replaceAll("[\\pP\\p{Punct}]",""))) //Compare word and stopword
                            StopFlag = 1;
                    }
                    if (StopFlag == 0)
                        IndexList.add(FileNum+","+Integer.toString(count+2));
                    TempLineWord = new char[30];
                    continue;
                }
                TempLineWord[TempIndex] = TempLine.charAt(count);
            }

            PrintWriter out = new PrintWriter("CirsularShiftIndex.txt");
            for (String a : IndexList){
                out.println(a);
                System.out.println(a);
            }
            //System.out.println(LineList.get(i).charAt(0));
        }
        return IndexList;
    }
}

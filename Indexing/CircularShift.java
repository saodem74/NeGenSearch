import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CircularShift {
    //Circular shift Index and remove stop word
    public List<String> GetCircularIndex(List<String> LineList, List<String> listOfFiles) throws FileNotFoundException {
        String stopString = "";
        stopString = new InputPages().Stopword2Line("./Indexing/stopword.txt");
        String[] StopArray = stopString.split(",");

        char[] TempLineWord = new char[200]; //create temp word saving parameter for possibly stop word
        int TempIndex = 0;
        int StopFlag = 0;

        List<String> IndexList = new ArrayList<String>();
        for (int i = 0; i < LineList.size(); i++) {
            String FileNum = listOfFiles.get(i).replace("page","");
            String TempLine = LineList.get(i).replaceAll("[\\pP\\p{Punct}]","");
            TempLine = TempLine.replaceAll("( )+"," ") + ' '; //Add last space for later split
            for (int count=0; count < TempLine.length(); count++){
                StopFlag = 0;
                if (TempLine.charAt(count) == ' '){ //Split the line by space
                    //Concate saved char into word (for compare with Stop word)
                    String ConcateWord = "";
                    String StringStop = new String(TempLineWord);//Change char array into string
                    ConcateWord = ConcateWord.concat(StringStop);//Concate the string
                    for (String StopCom : StopArray){
                        if(ConcateWord.trim().compareToIgnoreCase(StopCom.replaceAll("[\\pP\\p{Punct}]","")) == 0) //Compare word and stopword
                        {
                            StopFlag = 1;
                            break;
                        }
                    }
                    if (StopFlag == 0) {
                        IndexList.add(FileNum + "," + Integer.toString(count + 1 - ConcateWord.trim().length()));
                    }
                    TempLineWord = new char[200];
                    TempIndex = 0;
                }
                else {
                    TempLineWord[TempIndex] = TempLine.charAt(count);
                    TempIndex = TempIndex + 1;
                }
            }
        }
        PrintStream out = new PrintStream(new FileOutputStream("CircularShiftIndex.txt")); //Save unsorted index list into file
        for (String a : IndexList){
            out.print(a+'\n');
        }
        return IndexList;
    }
}

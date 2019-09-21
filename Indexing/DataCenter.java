import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    public List<String> GetLineList(String DirPath){
        List<String> listOfFiles = new ArrayList<String>();
        listOfFiles = new InputPages().GetPath(DirPath);


        String SaveLine = "";
        String FileNameString = "";
        List<String> LineList = new ArrayList<String>();
        //Read Each file in directory
        for (int i =0; i < listOfFiles.size(); i++){
            FileNameString = listOfFiles.get(i);
            SaveLine = new InputPages().Page2Line(DirPath+FileNameString);
            SaveLine = SaveLine.replaceAll("[\\pP\\p{Punct}]","");
            SaveLine = SaveLine.replaceAll("( )+"," ");
            LineList.add(SaveLine); //Save Webpage Line in "LineList"
        }
        return LineList;
    }

    public String getLine(List<String> LineList, int LineNum, int GapNum){
        String AssignLine = LineList.get(LineNum - 1);
        String ShiftedLine = AssignLine.substring(GapNum - 1) + AssignLine.substring(0,GapNum - 1);
        //System.out.println(ShiftedLine);
        return ShiftedLine;
    }
}

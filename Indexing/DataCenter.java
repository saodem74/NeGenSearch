import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    public List<String> GetLineList(String DirPath){ //Read all webpages in the folder and remove punctuation and extra space
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

    public String getLine(List<String> LineList, List<String> listOfFiles, int LineNum, int GapNum){ //Input index and output shifted line
        String AssignLine = LineList.get(listOfFiles.indexOf("page" + LineNum));
        String ShiftedLine = AssignLine.substring(GapNum - 1) + AssignLine.substring(0,GapNum - 1);
        return ShiftedLine;
    }

    public String getUrl(String PageNum) throws FileNotFoundException { //Map page number to page URL
        String MappingPage2URL = new InputPages().url2Line("./Crawler/src/main/resources/crawledData/mappingPageToUrl.txt");
        String[] MappingPageArray = MappingPage2URL.split(";");
        String[] NumAndURL = {};
        for (String MappingLine : MappingPageArray){
            NumAndURL = MappingLine.split(" "); //Split file path and URL
            String[] SplitNum = NumAndURL[0].split("page"); //Split page number from the file path
            if (SplitNum[2].replaceAll("\n", "").equals(PageNum)){ //Compare with PageNum you want
                break;
            }
        }
        return NumAndURL[1];
    }
}

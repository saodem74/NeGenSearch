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
            LineList.add(SaveLine); //Save Webpage Line in "LineList"
        }
        return LineList;
    }
}

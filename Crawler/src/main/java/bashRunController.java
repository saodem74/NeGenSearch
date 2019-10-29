import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bashRunController {
    public static void main(String[] args) {
        System.out.println("START");
        // Path to Crawler
        String path = "/Users/tranhieu/Dropbox/Fall2019/SW_architecuture/project/Crawler/";
        String bashFile = "search.sh";
//        String data = FileReader.readStringFromFile(path + bashFile);
//        System.out.println(data);

        Process p;
        try {

            List<String> cmdList = new ArrayList<String>();
            // adding command and args to the list
            cmdList.add("sh");
            cmdList.add(path + bashFile);
            cmdList.add("computer");
            ProcessBuilder pb = new ProcessBuilder(cmdList);
            p = pb.start();
            p.waitFor();

            // This code print out log
            BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("IOException");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("InterruptedException");
        }
        System.out.println("DONE");
    }
}

package project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class bashRunController {
    final static String path = "/Users/chunpingyang/Documents/SE6362/Crawler/";
    final static String bashFile = path + "search.sh";
    //final static String resultFile = "/Users/chunpingyang/Documents/NeGenSearch/web/resources/ResultSearch.txt";
    final static String resultFile = path + "/src/main/resources/ResultSearch.txt";
    static Process p;

    static String readStringFromFile(String inputFile) {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(inputFile));
            byte[] bytes = new byte[(int) new File(inputFile).length()];
            in.read(bytes);
            in.close();
            return new String(bytes);
        }
        catch (Exception e) {
            return null;
        }
    }
    static public List<String[]> getResultFromFile() {
        List<String[]> res = new ArrayList<String[]>();
        String data = readStringFromFile(bashRunController.resultFile);
        String[] lines = data.split("\n");
        for (int i = 0; i < lines.length; i += 3) {
            if (lines[i].isEmpty()) break;
            if (i + 1 >= lines.length) break;
            if (lines[i + 1].isEmpty()) break;
            String[] tmp = new String[2];
            tmp[0] = lines[i];
            tmp[1] = lines[i + 1];
            res.add(tmp);
        }

        System.out.println("data size: "+res.size());
        return res;
    }
    static public void searchQuery(String query) {
        try {

            List<String> cmdList = new ArrayList<String>();
            // adding command and args to the list
            cmdList.add("sh");
            cmdList.add(bashFile);
            cmdList.add(query);
            ProcessBuilder pb = new ProcessBuilder(cmdList);
            p = pb.start();
            p.waitFor();

            // This code print out log if needed
//            BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
//            String line;
//            while((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
        } catch (Exception e) {
            System.out.println(">>> Exception error");
        }
    }
}

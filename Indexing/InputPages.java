import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputPages {
    public String Page2Line(String filePath) {
        BufferedReader reader;
        String ReadLine = "";
        try {
            reader = new BufferedReader(new FileReader(
                    filePath));
            // read next line
            String line = reader.readLine();
            ReadLine = line;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ReadLine;
    }
}
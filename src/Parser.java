import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Klaudia on 04.11.2016.
 */
public class Parser {
    private final String singleLinePattern = "\\{(\\d+)\\}\\{(\\d+)\\}(.+)";
    private String changedLine;
    private ArrayList<String> result = new ArrayList<>();
    public String line;
    public Matcher matcher;

    public void moveLines(int length, ReadFromFile readFromFile) {
        try {
            Pattern pattern = Pattern.compile(singleLinePattern);
            Scanner scanner = new Scanner(readFromFile.getCurrentFilePath());

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    //group(0) to cale wyrazenie
                    int firstIntValue = Integer.parseInt(matcher.group(1));  // \d+
                    int secondIntValue = Integer.parseInt(matcher.group(2));  // \d+
                    String strValue = matcher.group(3);  // .+
                    if(firstIntValue > secondIntValue) throw new InvalidOrderException();
                    if(firstIntValue < 0) throw new OutOfBoundsException();
                    firstIntValue += length;
                    secondIntValue += length;

                    changedLine = String.format("{%d}{%d}%s", firstIntValue, secondIntValue, strValue);
                    result.add(changedLine);
                }
            }

            readFromFile.updateFile(result);
            scanner.close();

        } catch (IOException ex) {

            System.out.print(ex.toString());
        }
    }
}


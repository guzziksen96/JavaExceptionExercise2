/**
 * Created by Klaudia on 07.11.2016.
 */
public class SubtitlesApp{
    public static void main(String[] args) {
        ReadFromFile readFromFile = new ReadFromFile("src/subtitles.sub");
        Parser parser = new Parser();
        parser.moveLines(1, readFromFile);
    }
}
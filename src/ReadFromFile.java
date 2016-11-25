import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Klaudia on 04.11.2016.
 */
public class ReadFromFile{

    private final Path path;

    public ReadFromFile(String filePath) {
        path = Paths.get(filePath);
    }

    public Path getCurrentFilePath() {
        return Paths.get(path.toString());
    }

    public void updateFile(ArrayList<String> lines) throws IOException {
        Files.write(Paths.get(path.toString()), lines);
    }
}




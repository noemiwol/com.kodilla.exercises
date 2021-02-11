package transformer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTransformer {
    private String pathInput = "C:\\Users\\noemi\\IdeaProjects\\com.kodilla.exercises\\springIntegration\\data\\input";
    private String pathOutput ="C:\\Users\\noemi\\IdeaProjects\\com.kodilla.exercises\\springIntegration\\data\\output";

    public String transformFile() throws IOException {
        StringBuilder result = new StringBuilder();
        boolean fileExist = new File(pathOutput).isFile();
        if (fileExist) {
            Files.readAllLines(Paths.get(pathOutput))
                    .forEach(line -> result.append(line).append("\n"));
        }
        File[] files = new File(pathInput).listFiles();
        for (File file : files) {
            if (!result.toString().contains(file.getName())) {
                result.append(file.getName()).append("\n");
            }
        }
        return result.toString().strip();
    }
}

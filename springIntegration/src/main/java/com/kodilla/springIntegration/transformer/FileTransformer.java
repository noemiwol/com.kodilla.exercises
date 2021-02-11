package com.kodilla.springIntegration.transformer;

import com.kodilla.springIntegration.configuration.FilePathsConstants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTransformer {

    public void  transformFile() throws IOException {
        StringBuilder result = new StringBuilder();
        boolean fileExist = new File(FilePathsConstants.pathOutput).isFile();
        if (fileExist) {
            Files.readAllLines(Paths.get(FilePathsConstants.pathOutput))
                    .forEach(line -> result.append(line).append("\n"));
        }
        File[] files = new File(FilePathsConstants.pathInput).listFiles();
        if(files == null){
            return;
        }

        for (File file : files) {
            if (!result.toString().contains(file.getName())) {
                result.append(file.getName()).append("\n");
            }
        }

    }
}
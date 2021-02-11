package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import transformer.FileTransformer;

import java.io.File;

import static org.springframework.integration.file.support.FileExistsMode.REPLACE;
@Configuration
public class FileIntegrationConfiguration {
    private String pathInput = "C:\\Users\\noemi\\IdeaProjects\\com.kodilla.exercises\\springIntegration\\data\\input";
    private String pathOutput ="C:\\Users\\noemi\\IdeaProjects\\com.kodilla.exercises\\springIntegration\\data\\output";

    @Bean
    IntegrationFlow fileIntegrationFlow(FileReadingMessageSource fileAdapter, FileTransformer transformer, FileWritingMessageHandler outputFileHandler) {
        return IntegrationFlows.from(fileAdapter, config -> config.poller(Pollers.fixedDelay(1000,0)))
                .transform(transformer, "transformFile")
                .handle(outputFileHandler)
                .get();
    }

    @Bean
    FileReadingMessageSource fileAdapter() {
        FileReadingMessageSource fileSource = new FileReadingMessageSource();
        fileSource.setDirectory(new File(pathInput));
        return fileSource;
    }

    @Bean
    FileTransformer transformer() {
        return new FileTransformer();
    }

    @Bean
    FileWritingMessageHandler outputFileAdapter() {
        File directory = new File(pathOutput);
        FileWritingMessageHandler handler = new FileWritingMessageHandler(directory);
        handler.setExpectReply(false);
        handler.setAppendNewLine(true);
        handler.setFileExistsMode(REPLACE);
        handler.setFileNameGenerator(message -> "files.txt");
        return handler;
    }
}

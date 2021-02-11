package configuration;

import domian.UserAge;
import domian.UserDateOfBirth;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@Configuration
@RequiredArgsConstructor
@EnableBatchProcessing
public class BatchConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataChangesMapper dataChangesMapper;



    @Bean
    FlatFileItemReader<UserDateOfBirth> reader() {
        FlatFileItemReader<UserDateOfBirth> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("input.csv"));

        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames("name", "surName", "birthDate");

        BeanWrapperFieldSetMapper<UserDateOfBirth> mapper = new BeanWrapperFieldSetMapper<>();
        mapper.setTargetType(UserDateOfBirth.class);

        DefaultLineMapper<UserDateOfBirth> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(dataChangesMapper);

        reader.setLineMapper(lineMapper);
        return reader;
    }


    @Bean
    FlatFileItemWriter<UserAge> writer() {
        BeanWrapperFieldExtractor<UserAge> extractor = new BeanWrapperFieldExtractor<>();
        extractor.setNames(new String[]{"name", "surName", "age"});

        DelimitedLineAggregator<UserAge> aggregator = new DelimitedLineAggregator<>();
        aggregator.setDelimiter(",");
        aggregator.setFieldExtractor(extractor);

        FlatFileItemWriter<UserAge> writer = new FlatFileItemWriter<>();
        writer.setShouldDeleteIfExists(true);
        writer.setLineAggregator(aggregator);
        writer.setResource(new FileSystemResource("ConvertedPersons.csv"));

        return writer;
    }

    @Bean
    Step changeDateToAgeStep(
            ItemReader<UserDateOfBirth> reader,
            ItemProcessor<UserDateOfBirth, UserAge> processor,
            ItemWriter<UserAge> writer) {

        return stepBuilderFactory.get("changeDateToAge")
                .<UserDateOfBirth, UserAge>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    Job changeDateToAgeJob(Step step) {
        return jobBuilderFactory.get("changeDateToAge")
                .incrementer(new RunIdIncrementer())
                .flow(step)
                .end()
                .build();
    }

}


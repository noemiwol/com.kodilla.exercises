package com.kodilla.birthdayApp.configuration;

import com.kodilla.birthdayApp.domian.UserDateOfBirth;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DataChangesMapper extends BeanWrapperFieldSetMapper<UserDateOfBirth> {
    public DataChangesMapper  () {
        setTargetType(UserDateOfBirth.class);
    }

    @Override
    public UserDateOfBirth mapFieldSet(FieldSet fs) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        UserDateOfBirth userDateOfBirth = new UserDateOfBirth();
        userDateOfBirth.setName(fs.readString("name"));
        userDateOfBirth.setSurName(fs.readString("surName"));
        String date = fs.readString("dateOfBirth");
        userDateOfBirth.setDateOfBirth(LocalDate.parse(date, formatter));
        return userDateOfBirth;
    }

}

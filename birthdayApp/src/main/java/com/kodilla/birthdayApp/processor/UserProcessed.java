package com.kodilla.birthdayApp.processor;

import com.kodilla.birthdayApp.domian.UserAge;
import com.kodilla.birthdayApp.domian.UserDateOfBirth;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class UserProcessed implements ItemProcessor<UserDateOfBirth, UserAge> {

    @Override
    public UserAge process(UserDateOfBirth item) throws Exception {

            return new UserAge(
                    item.getName(),
                    item.getSurName(),
                    ChronoUnit.YEARS.between(item.getDateOfBirth(), LocalDate.now()));

    }
}

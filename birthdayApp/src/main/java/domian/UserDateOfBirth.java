package domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDateOfBirth {
    private String name;
    private String surName;
    private LocalDate dateOfBirth;

}

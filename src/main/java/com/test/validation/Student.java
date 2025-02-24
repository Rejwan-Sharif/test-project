package com.test.validation;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Positive
    private Long id;
    @NotBlank
    private String name;
    @Range(min = 18,max = 60)
    private Integer age;
    @Positive
    @Range(max = 4)
    private float cgpa;
    @Email
    private String email;
    private String phoneNumber;
}

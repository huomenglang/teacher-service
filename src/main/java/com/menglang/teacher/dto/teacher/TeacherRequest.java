package com.menglang.teacher.dto.teacher;

import com.menglang.teacher.model.enums.Gender;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

public record TeacherRequest(

        @NotNull(message = "First Name is Require!")
        @NotBlank(message = "First Name must not be Blank!")
        @Size(message = "First Name at lease has 3 Character and Maximum 30 characters",min = 3,max = 30)
        String firstName,

        @NotNull(message = "Last Name is Require!")
        @NotBlank(message = "Last Name must not be Blank!")
        @Size(message = "Lasst Name at lease has 3 Character and Maximum 30 characters")
        String lastName,

        @NotNull(message = "Gender is Require!")
        Gender gender,

        @NotNull(message = "BirthDate is Require!")
        LocalDate birthDate,

        @NotNull(message = "Image is Require!")
        @NotBlank(message = "Image must not be Blank!")
        String imageUrl,

        @NotNull(message = "Phone Number is Require!")
        @NotBlank(message = "Phone Number must not be Blank!")
        @Size(message = "First Name at lease has 9 Character and Maximum 20 characters",min = 3,max = 20)
        String phoneNumber,

        @NotNull(message = "Address is Require!")
        @NotBlank(message = "Address must not be Blank!")
        String address,

        @NotNull(message = "Start Date is Require!")
        LocalDate startedDate,

        @NotNull(message = "Salary is required.")
        @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0.")
        Double salary
) implements Serializable {
}

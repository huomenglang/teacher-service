package com.menglang.teacher.dto.teacher;

import com.menglang.teacher.model.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record TeacherResponse(
        Long id,
        String firstName,
        String lastName,
        Gender gender,
        LocalDate birthDate,
        String imageUrl,
        String phoneNumber,
        String address,
        LocalDate startedDate,
        Double salary,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime updatedAt,
        String updatedBy
) implements Serializable {
}

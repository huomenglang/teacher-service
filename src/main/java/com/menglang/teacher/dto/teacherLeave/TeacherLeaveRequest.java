package com.menglang.teacher.dto.teacherLeave;

import com.menglang.teacher.model.enums.LeaveTime;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

public record TeacherLeaveRequest(
        @NotNull(message = "Teacher ID must not be null!")
        @Positive(message = "Teacher ID must be a positive number!")
        Long teacherId,

        @NotNull(message = "Start date is required!")
        @FutureOrPresent(message = "Start date cannot be in the past!")
        LocalDate startDate,

        @NotNull(message = "End date is required!")
        @FutureOrPresent(message = "End date cannot be in the past!")
        LocalDate endDate,

        @NotNull(message = "Leave time is required!")
        LeaveTime leaveTime,

        @NotBlank(message = "Reason must not be blank!")
        @Size(max = 200, message = "Reason must be less than or equal to 200 characters!")
        String reason
) implements Serializable {
}

package com.menglang.teacher.dto.teacherLeave;

import com.menglang.teacher.model.entities.Teacher;
import com.menglang.teacher.model.enums.LeaveTime;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

public record TeacherLeaveResponse(
        Long id,
        Teacher teacher,
        LocalDate startDate,
        LocalDate endDate,
        LeaveTime leaveTime,
        Short leaveQty,
        String reason
) implements Serializable {

}

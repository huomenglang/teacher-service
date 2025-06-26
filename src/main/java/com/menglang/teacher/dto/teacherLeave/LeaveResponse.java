package com.menglang.teacher.dto.teacherLeave;

import com.menglang.teacher.model.enums.LeaveTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class LeaveResponse {
    private LocalDate startDate;
    private LocalDate endDate;
    private LeaveTime leaveTime;
    private Short leaveQty;
    private String reason;
}

package com.menglang.teacher.dto.teacherLeave;

import com.menglang.common.library.page.paginate.BasePageResponse;
import com.menglang.teacher.model.entities.Teacher;
import com.menglang.teacher.model.enums.LeaveTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class TeacherLeaveResponse extends BasePageResponse {
    private Long id;
    private Teacher teacher;
    private LocalDate startDate;
    private LocalDate endDate;
    private LeaveTime leaveTime;
    private Short leaveQty;
    private String reason;
}


package com.menglang.teacher.dto.teacherLeave;

import com.menglang.common.library.page.paginate.BasePageResponse;
import com.menglang.teacher.model.entities.Teacher;
import com.menglang.teacher.model.enums.LeaveTime;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class TeacherLeaveResponseList extends BasePageResponse {
        private Long id;
        private Teacher teacher;
        private List<LeaveResponse> leaveResponses;
}


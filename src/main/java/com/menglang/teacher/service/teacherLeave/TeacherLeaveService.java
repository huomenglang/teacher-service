package com.menglang.teacher.service.teacherLeave;

import com.menglang.teacher.dto.teacherLeave.TeacherLeaveRequest;
import com.menglang.teacher.dto.teacherLeave.TeacherLeaveResponse;
import com.menglang.teacher.dto.teacherLeave.TeacherLeaveResponseList;
import com.menglang.teacher.model.entities.Teacher;
import com.menglang.teacher.model.entities.TeacherLeave;
import com.menglang.teacher.service.BaseService.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface TeacherLeaveService extends BaseService<TeacherLeaveRequest, TeacherLeaveResponse> {

    Page<TeacherLeave> findLeaveByTeacherId(Map<String, String> params);
    TeacherLeaveResponseList getTeacherLeaveListResponse( Page<TeacherLeave> teacherLeavePage);
}

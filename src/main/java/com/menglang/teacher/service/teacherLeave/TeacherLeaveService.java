package com.menglang.teacher.service.teacherLeave;

import com.menglang.teacher.dto.teacherLeave.TeacherLeaveRequest;
import com.menglang.teacher.dto.teacherLeave.TeacherLeaveResponse;
import com.menglang.teacher.model.entities.TeacherLeave;
import com.menglang.teacher.service.BaseService.BaseService;

import java.util.List;

public interface TeacherLeaveService extends BaseService<TeacherLeaveRequest, TeacherLeaveResponse> {

    List<TeacherLeave> findLeaveByTeacherId(Long teacherId);
}

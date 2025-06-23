package com.menglang.teacher.service.teacher;

import com.menglang.teacher.dto.teacher.TeacherRequest;
import com.menglang.teacher.dto.teacher.TeacherResponse;
import com.menglang.teacher.model.entities.Teacher;
import com.menglang.teacher.service.BaseService.BaseService;

import java.util.List;

public interface TeacherService extends BaseService<TeacherRequest, TeacherResponse> {
    List<Teacher> getAll();
}

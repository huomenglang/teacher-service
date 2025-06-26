package com.menglang.teacher.service.teacher;

import com.menglang.teacher.dto.teacher.TeacherRequest;
import com.menglang.teacher.dto.teacher.TeacherResponse;
import com.menglang.teacher.model.entities.Teacher;
import com.menglang.teacher.service.BaseService.BaseService;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface TeacherService extends BaseService<TeacherRequest, TeacherResponse> {
    Page<Teacher> getAll(Map<String,String> params);
}

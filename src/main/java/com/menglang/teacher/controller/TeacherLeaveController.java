package com.menglang.teacher.controller;

import com.menglang.common.library.page.PageResponse;
import com.menglang.common.library.page.PageResponseHandler;
import com.menglang.teacher.dto.teacher.TeacherRequest;
import com.menglang.teacher.dto.teacher.TeacherResponse;
import com.menglang.teacher.dto.teacherLeave.TeacherLeaveRequest;
import com.menglang.teacher.dto.teacherLeave.TeacherLeaveResponse;
import com.menglang.teacher.dto.teacherLeave.TeacherLeaveResponseList;
import com.menglang.teacher.model.entities.TeacherLeave;
import com.menglang.teacher.service.teacher.TeacherService;
import com.menglang.teacher.service.teacherLeave.TeacherLeaveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teacher-leaves")
@RequiredArgsConstructor
public class TeacherLeaveController {

    private final TeacherLeaveService leaveService;

    @PostMapping
    public ResponseEntity<PageResponse> create(@Valid @RequestBody TeacherLeaveRequest data){
        return PageResponseHandler.success(leaveService.create(data),null,"Create Successful");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PageResponse> getById(@PathVariable Long id){
        return PageResponseHandler.success(leaveService.getById(id),null,"Get Successful");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PageResponse> updateTeacher(@Valid @RequestBody TeacherLeaveRequest data,@PathVariable Long id){
        return PageResponseHandler.success(leaveService.update(id,data),null,"Update Successful");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PageResponse> delete(@PathVariable Long id){
        return PageResponseHandler.success(leaveService.delete(id),null,"Delete Successful");
    }

    @GetMapping("/teacher_id")
    public ResponseEntity<PageResponse> getAllTeachersById(@RequestParam Map<String,String> params){
        Page<TeacherLeave> teacherLeavePage=leaveService.findLeaveByTeacherId(params);
        TeacherLeaveResponseList teacherLeaveResponseList=leaveService.getTeacherLeaveListResponse(teacherLeavePage);
        return PageResponseHandler.success(teacherLeaveResponseList,teacherLeavePage,"Get Successful");

    }
}

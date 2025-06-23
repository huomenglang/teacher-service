package com.menglang.teacher.controller;

import com.menglang.teacher.dto.teacher.TeacherRequest;
import com.menglang.teacher.dto.teacher.TeacherResponse;
import com.menglang.teacher.dto.teacherLeave.TeacherLeaveRequest;
import com.menglang.teacher.dto.teacherLeave.TeacherLeaveResponse;
import com.menglang.teacher.service.teacher.TeacherService;
import com.menglang.teacher.service.teacherLeave.TeacherLeaveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teacher-leaves")
@RequiredArgsConstructor
public class TeacherLeaveController {

    private final TeacherLeaveService leaveService;

    @GetMapping
    public String teacher() {
        return "teacher Greeting!";
    }

    @PostMapping
    public ResponseEntity<TeacherLeaveResponse> create(@Valid @RequestBody TeacherLeaveRequest data){
        return ResponseEntity.ok(leaveService.create(data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TeacherLeaveResponse>> getById(@PathVariable Long id){
        return ResponseEntity.ok(leaveService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherLeaveResponse> updateTeacher(@Valid @RequestBody TeacherLeaveRequest data,@PathVariable Long id){
        return ResponseEntity.ok(leaveService.update(id,data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TeacherLeaveResponse> delete(@PathVariable Long id){
        return ResponseEntity.ok(leaveService.delete(id));
    }
}

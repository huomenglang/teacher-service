package com.menglang.teacher.controller;

import com.menglang.teacher.dto.teacher.TeacherRequest;
import com.menglang.teacher.dto.teacher.TeacherResponse;
import com.menglang.teacher.model.entities.Teacher;
import com.menglang.teacher.service.teacher.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public String teacher() {
        return "teacher Greeting!";
    }

    @PostMapping
    public ResponseEntity<TeacherResponse> create(@Valid @RequestBody TeacherRequest data){
        return ResponseEntity.ok(teacherService.create(data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TeacherResponse>> getById(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponse> updateTeacher(@Valid @RequestBody TeacherRequest data,@PathVariable Long id){
        return ResponseEntity.ok(teacherService.update(id,data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TeacherResponse> delete(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.delete(id));
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<Teacher>> getAll(){
        return ResponseEntity.ok(teacherService.getAll());
    }
}

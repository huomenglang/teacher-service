package com.menglang.teacher.controller;

import com.menglang.common.library.page.PageResponse;
import com.menglang.common.library.page.PageResponseHandler;
import com.menglang.teacher.dto.teacher.TeacherMapper;
import com.menglang.teacher.dto.teacher.TeacherRequest;
import com.menglang.teacher.dto.teacher.TeacherResponse;
import com.menglang.teacher.model.entities.Teacher;
import com.menglang.teacher.service.teacher.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private static final Logger log = LoggerFactory.getLogger(TeacherController.class);
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @PostMapping
    public ResponseEntity<PageResponse> create(@Valid @RequestBody TeacherRequest data){
        log.info("data input{}",data.firstName());
        return PageResponseHandler.success(teacherService.create(data),null,"Create Successful");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PageResponse> getById(@PathVariable Long id){
        return PageResponseHandler.success(teacherService.getById(id),null,"Get Successful.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PageResponse> updateTeacher(@Valid @RequestBody TeacherRequest data,@PathVariable Long id){
        return  PageResponseHandler.success(teacherService.update(id,data),null,"Update Successful");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PageResponse> delete(@PathVariable Long id){
        return PageResponseHandler.success(teacherService.delete(id),null,"Delete Successful");
    }
    @GetMapping("/get-all")
    public ResponseEntity<PageResponse> getAll(@PathVariable Map<String,String> params){
        Page<Teacher> teacherPage=teacherService.getAll(params);
        List<TeacherResponse> teacherResponseList= teacherPage.getContent().stream().map(teacherMapper::toTeacherResponse).toList();
        return PageResponseHandler.success(teacherResponseList,teacherPage,"Get Successful");
    }
}

package com.menglang.teacher.service.teacherLeave;

import com.menglang.teacher.dto.teacherLeave.TeacherLeaveMapper;
import com.menglang.teacher.dto.teacherLeave.TeacherLeaveRequest;
import com.menglang.teacher.dto.teacherLeave.TeacherLeaveResponse;
import com.menglang.teacher.model.entities.TeacherLeave;
import com.menglang.teacher.repository.TeacherLeaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TeacherLeaveServiceImpl implements TeacherLeaveService{
    private final TeacherLeaveMapper teacherLeaveMapper;
    private final TeacherLeaveRepository teacherLeaveRepository;

    @Override
    public TeacherLeaveResponse create(TeacherLeaveRequest dto) {
        TeacherLeave teacherLeave=teacherLeaveMapper.toEntity(dto);
        try{
            return teacherLeaveMapper.toResponse(teacherLeaveRepository.save(teacherLeave));
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public TeacherLeaveResponse update(Long id, TeacherLeaveRequest dto) {
        TeacherLeave teacherLeave=this.findLeaveById(id);
        teacherLeaveMapper.toTeacherLeaveUpdate(dto,teacherLeave);
        try{
            return teacherLeaveMapper.toResponse(teacherLeaveRepository.save(teacherLeave));
        }catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public TeacherLeaveResponse delete(Long id) {
        TeacherLeave teacherLeave=this.findLeaveById(id);
        try{
            teacherLeaveRepository.deleteById(id);
            return teacherLeaveMapper.toResponse(teacherLeave);
        }catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<TeacherLeaveResponse> getById(Long id) {
        TeacherLeave teacherLeave=this.findLeaveById(id);
        return Optional.ofNullable(teacherLeaveMapper.toResponse(teacherLeave));
    }

    private TeacherLeave findLeaveById(Long leaveId){
     return  teacherLeaveRepository.findById(leaveId).orElseThrow(()->new RuntimeException("Not Found."));
    }

    @Override
    public List<TeacherLeave> findLeaveByTeacherId(Long teacherId) {
        return List.of();
    }
}

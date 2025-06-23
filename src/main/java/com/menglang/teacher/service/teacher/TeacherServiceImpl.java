package com.menglang.teacher.service.teacher;

import com.menglang.teacher.dto.teacher.TeacherMapper;
import com.menglang.teacher.dto.teacher.TeacherRequest;
import com.menglang.teacher.dto.teacher.TeacherResponse;
import com.menglang.teacher.model.entities.Teacher;
import com.menglang.teacher.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public TeacherResponse create(TeacherRequest dto) {
        Teacher teacher=teacherMapper.toTeacherEntity(dto);
        try{
         return teacherMapper.toTeacherResponse(teacherRepository.save(teacher));
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public TeacherResponse update(Long id, TeacherRequest dto) {
        Teacher updateTeacher=this.findTeacherById(id);
        teacherMapper.toTeacherUpdate(dto,updateTeacher);
        try{
            return teacherMapper.toTeacherResponse(teacherRepository.save(updateTeacher));
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public TeacherResponse delete(Long id) {
        Teacher teacher=this.findTeacherById(id);
        try{
            teacherRepository.deleteById(id);
            return teacherMapper.toTeacherResponse(teacher);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<TeacherResponse> getById(Long id) {
        Teacher teacher=this.findTeacherById(id);
        return Optional.ofNullable(teacherMapper.toTeacherResponse(teacher));
    }

    private Teacher findTeacherById(Long id){
        return teacherRepository.findById(id).orElseThrow(()->new RuntimeException(" Teacher not found."));
    }
}

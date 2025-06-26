package com.menglang.teacher.service.teacherLeave;

import com.menglang.common.library.exceptions.common.BadRequestException;
import com.menglang.common.library.exceptions.common.NotFoundException;
import com.menglang.common.library.page.PageResponse;
import com.menglang.common.library.page.parser.PageableParser;
import com.menglang.teacher.dto.teacherLeave.TeacherLeaveMapper;
import com.menglang.teacher.dto.teacherLeave.TeacherLeaveRequest;
import com.menglang.teacher.dto.teacherLeave.TeacherLeaveResponse;
import com.menglang.teacher.dto.teacherLeave.TeacherLeaveResponseList;
import com.menglang.teacher.model.entities.Teacher;
import com.menglang.teacher.model.entities.TeacherLeave;
import com.menglang.teacher.repository.TeacherLeaveRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TeacherLeaveServiceImpl implements TeacherLeaveService{
    private static final Logger log = LoggerFactory.getLogger(TeacherLeaveServiceImpl.class);
    private final TeacherLeaveMapper teacherLeaveMapper;
    private final TeacherLeaveRepository teacherLeaveRepository;

    @Override
    public TeacherLeaveResponse create(TeacherLeaveRequest dto) {
        TeacherLeave teacherLeave=teacherLeaveMapper.toEntity(dto);
        try{
            return teacherLeaveMapper.toResponse(teacherLeaveRepository.save(teacherLeave));
        }catch (BadRequestException e){
            log.warn(e.getMessage());
            throw new BadRequestException("Unable to create Leave.");
        }catch(RuntimeException e){
            log.warn(e.getMessage());
            throw new RuntimeException("Unable to create Leave.");
        }

    }

    @Override
    public TeacherLeaveResponse update(Long id, TeacherLeaveRequest dto) {
        TeacherLeave teacherLeave=this.findLeaveById(id);
        teacherLeaveMapper.toTeacherLeaveUpdate(dto,teacherLeave);
        try{
            return teacherLeaveMapper.toResponse(teacherLeaveRepository.save(teacherLeave));
        }catch (BadRequestException e){
            log.warn(e.getMessage());
            throw new BadRequestException("Unable to Update Leave.");
        }catch(RuntimeException e){
            log.warn(e.getMessage());
            throw new RuntimeException("Unable to Update Leave.");
        }
    }

    @Override
    public TeacherLeaveResponse delete(Long id) {
        TeacherLeave teacherLeave=this.findLeaveById(id);
        try{
            teacherLeaveRepository.deleteById(id);
            return teacherLeaveMapper.toResponse(teacherLeave);
        }catch (BadRequestException e){
            log.warn(e.getMessage());
            throw new BadRequestException("Unable to Delete Leave.");
        }catch(RuntimeException e){
            log.warn(e.getMessage());
            throw new RuntimeException("Unable to Delete Leave.");
        }
    }

    @Override
    public Optional<TeacherLeaveResponse> getById(Long id) {
        TeacherLeave teacherLeave=this.findLeaveById(id);
        return Optional.ofNullable(teacherLeaveMapper.toResponse(teacherLeave));
    }

    private TeacherLeave findLeaveById(Long leaveId){
     return  teacherLeaveRepository.findById(leaveId).orElseThrow(()->new NotFoundException("Not Found."));
    }

    @Override
    public Page<TeacherLeave> findLeaveByTeacherId(Map<String, String> params) {
        Long teacherId=parseLongOrDefault(params.get("id"), 0L);
        log.info("teacher id: {}",teacherId);
        Pageable pageable= PageableParser.from(params);
        return teacherLeaveRepository.findLeaveByTeacherId(teacherId,pageable);
    }

    @Override
    public TeacherLeaveResponseList getTeacherLeaveListResponse(Page<TeacherLeave> teacherLeavePage){
        List<TeacherLeave> teacherLeaveList=teacherLeavePage.getContent();
        Teacher teacher = teacherLeaveList.getFirst().getTeacher();
        Long id = teacherLeaveList.getFirst().getId();
        return teacherLeaveMapper.toTeacherLeavesResponseList(id,teacher,teacherLeaveList);
    }
    private static Long parseLongOrDefault(String val, Long defaultVal) {
        try {
            return val != null ? Long.parseLong(val) : defaultVal;
        } catch (NumberFormatException var3) {
            return defaultVal;
        }
    }
}

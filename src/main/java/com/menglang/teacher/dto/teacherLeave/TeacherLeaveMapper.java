package com.menglang.teacher.dto.teacherLeave;

import com.menglang.teacher.dto.teacher.TeacherRequest;
import com.menglang.teacher.model.entities.Teacher;
import com.menglang.teacher.model.entities.TeacherLeave;
import com.menglang.teacher.repository.TeacherRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TeacherLeaveMapper {


    private static final Logger log = LoggerFactory.getLogger(TeacherLeaveMapper.class);
    protected TeacherRepository teacherRepository;

    @Autowired
    public void TeacherLeaveMapper(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Mapping(target = "leaveQty", ignore = true)
    @Mapping(target = "teacher", expression = "java(mapTeacher(request.teacherId()))")
    public abstract TeacherLeave toEntity(TeacherLeaveRequest request);

    //    @Mapping(target = "teacher",source = "teacher",expression = "java(mapTeacher(request.teacher()))")
    public abstract TeacherLeaveResponse toResponse(TeacherLeave request);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "leaveQty", ignore = true)
    @Mapping(target = "teacher", expression = "java(mapTeacher(request.teacherId()))")
    public abstract void toTeacherLeaveUpdate(TeacherLeaveRequest request, @MappingTarget TeacherLeave teacher);


    @Named("mapTeacher")
    protected Teacher mapTeacher(Long teacherId) {
        log.info("teacher id: {}", teacherId);
        return teacherRepository.findById(teacherId).orElseThrow(() -> new RuntimeException("Teacher Not Found"));
    }


    @Mapping(target = "id", expression = "java(id)")
    @Mapping(target = "teacher", expression = "java(teacher)")
    @Mapping(target = "leaveResponses", expression = "java(mapLeaveResponse(teacherLeaves))")
    public abstract TeacherLeaveResponseList toTeacherLeavesResponseList(Long id, Teacher teacher, List<TeacherLeave> teacherLeaves);


    @Named("mapLeaveResponse")
    protected List<LeaveResponse> mapLeaveResponse(List<TeacherLeave> teacherLeaves) {
        return teacherLeaves.stream().map(l -> new LeaveResponse(
                l.getStartDate(),
                l.getEndDate(),
                l.getLeaveTime(),
                l.getLeaveQty(),
                l.getReason()
        )).toList();
    }
}

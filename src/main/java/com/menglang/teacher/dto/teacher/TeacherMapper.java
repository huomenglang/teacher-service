package com.menglang.teacher.dto.teacher;

import com.menglang.teacher.model.entities.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    Teacher toTeacherEntity(TeacherRequest request);
    TeacherResponse toTeacherResponse(Teacher request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    void toTeacherUpdate(TeacherRequest request, @MappingTarget Teacher teacher);
}

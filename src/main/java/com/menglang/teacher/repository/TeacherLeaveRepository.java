package com.menglang.teacher.repository;

import com.menglang.teacher.model.entities.TeacherLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherLeaveRepository extends JpaRepository<TeacherLeave,Long> {


    List<TeacherLeave> findLeaveByTeacherId(Long id);
}

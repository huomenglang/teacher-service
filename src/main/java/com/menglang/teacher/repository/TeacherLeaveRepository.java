package com.menglang.teacher.repository;

import com.menglang.teacher.model.entities.TeacherLeave;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherLeaveRepository extends JpaRepository<TeacherLeave,Long>, JpaSpecificationExecutor<TeacherLeave> {


    @Query(value = "SELECT * FROM teacher_leave where teacher_id = :teacherId   ",nativeQuery = true)
    Page<TeacherLeave> findLeaveByTeacherId(@Param("teacherId") Long teacherId, Pageable pageable);

}

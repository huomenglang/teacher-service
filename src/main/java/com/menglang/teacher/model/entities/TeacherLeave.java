package com.menglang.teacher.model.entities;


import com.menglang.teacher.model.audit.AuditEntity;
import com.menglang.teacher.model.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.boot.model.source.spi.IdentifierSource;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "teacher_leave")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherLeave extends AuditEntity<Long> {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "leave_time")
    private LocalTime leaveTime;

    @Column(length = 200)
    private String reason;
}

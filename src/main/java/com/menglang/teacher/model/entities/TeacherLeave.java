package com.menglang.teacher.model.entities;


import com.menglang.teacher.model.audit.AuditEntity;
import com.menglang.teacher.model.audit.BaseEntity;
import com.menglang.teacher.model.enums.LeaveTime;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.hibernate.boot.model.source.spi.IdentifierSource;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "teacher_leave")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherLeave extends AuditEntity<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "leave_time",length = 20)
    @Enumerated(EnumType.STRING)
    private LeaveTime leaveTime;

    @Transient
    private Short leaveQty;

    @Column(length = 200)
    private String reason;

    public Short getLeaveQty() {
        if (startDate == null || endDate == null || startDate.isAfter(endDate)) {
            return (short) 0;
        }
        var days = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return (short) days;
    }
}

package com.menglang.teacher.model.entities;


import com.menglang.teacher.model.audit.AuditEntity;
import com.menglang.teacher.model.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "teacher",indexes = {@Index(name = "idx_student_name", columnList = "firstName,lastName")})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher extends AuditEntity<Long> {
    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "phone_number",unique = true)
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name ="started_date" )
    private LocalDate startedDate;

    private BigDecimal salary;

}

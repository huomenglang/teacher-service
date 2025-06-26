package com.menglang.teacher.dto.teacher;
import com.menglang.common.library.page.paginate.BasePageResponse;
import com.menglang.teacher.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TeacherResponse extends BasePageResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private String imageUrl;
    private String phoneNumber;
    private String address;
    private LocalDate startedDate;
    private Double salary;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}

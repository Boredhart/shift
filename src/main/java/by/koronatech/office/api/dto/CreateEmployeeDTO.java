package by.koronatech.office.api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class CreateEmployeeDTO {

    private String name;

    private String department;

    private Boolean isManager;
}

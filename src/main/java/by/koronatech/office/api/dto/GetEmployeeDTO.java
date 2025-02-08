package by.koronatech.office.api.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetEmployeeDTO {

    private Long id;

    private String name;

    private String department;

    private Boolean isManager;
}

package by.koronatech.office.core.entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class EmployeeEntity {

    private Long id;

    private String name;

    private String department;

    private Boolean isManager;
}

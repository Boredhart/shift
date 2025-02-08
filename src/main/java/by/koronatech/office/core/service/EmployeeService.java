package by.koronatech.office.core.service;

import by.koronatech.office.api.dto.CreateEmployeeDTO;
import by.koronatech.office.api.dto.GetEmployeeDTO;

import java.util.List;

public interface EmployeeService {

    GetEmployeeDTO getById(long id);

    List<GetEmployeeDTO> getByName(String name);

    GetEmployeeDTO create(CreateEmployeeDTO createEmployeeDTO);

    GetEmployeeDTO update(long id, CreateEmployeeDTO createEmployeeDTO);

    void delete(long id);
}

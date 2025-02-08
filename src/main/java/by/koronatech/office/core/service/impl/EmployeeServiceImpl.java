package by.koronatech.office.core.service.impl;

import by.koronatech.office.api.dto.CreateEmployeeDTO;
import by.koronatech.office.api.dto.GetEmployeeDTO;
import by.koronatech.office.core.entity.EmployeeEntity;
import by.koronatech.office.core.mapper.employee.CreateEmployeeMapper;
import by.koronatech.office.core.mapper.employee.GetEmployeeMapper;
import by.koronatech.office.core.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final GetEmployeeMapper getEmployeeMapper;
    private final CreateEmployeeMapper createEmployeeMapper;

    private final List<EmployeeEntity> cachedRepository = new ArrayList<>(
            List.of(
                    EmployeeEntity.builder().id(1L).name("Вероника").department("Работа мечты").isManager(true).build(),
                    EmployeeEntity.builder().id(2L).name("Евгений").department("Работа мечты").isManager(true).build()
            )
    );

    @Override
    public GetEmployeeDTO getById(long id) {
        return getEmployeeMapper.toDto(findById(id));
    }

    @Override
    public List<GetEmployeeDTO> getByName(String name) {
        return getEmployeeMapper.toDtos(
                cachedRepository.stream()
                        .filter(employeeEntity -> employeeEntity.getName().equals(name))
                        .collect(Collectors.toList()));
    }

    @Override
    public GetEmployeeDTO create(CreateEmployeeDTO createEmployeeDTO) {
        cachedRepository.add(createEmployeeMapper.toEntity(createEmployeeDTO));
        return getEmployeeMapper.toDto(createEmployeeMapper.toEntity(createEmployeeDTO));
    }

    @Override
    public GetEmployeeDTO update(long id, CreateEmployeeDTO createEmployeeDTO) {
        EmployeeEntity employeeEntity = findById(id);
        createEmployeeMapper.merge(employeeEntity, createEmployeeDTO);
        log.info("After update: {}", employeeEntity);
        return getEmployeeMapper.toDto(employeeEntity);
    }

    @Override
    public void delete(long id) {
        cachedRepository.remove(findById(id));
    }

    private EmployeeEntity findById(long id) {
        return cachedRepository.stream()
                .filter(employeeEntity -> employeeEntity.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found."));
    }
}

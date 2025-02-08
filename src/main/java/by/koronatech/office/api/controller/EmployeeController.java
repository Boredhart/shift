package by.koronatech.office.api.controller;

import by.koronatech.office.api.dto.CreateEmployeeDTO;
import by.koronatech.office.api.dto.GetEmployeeDTO;
import by.koronatech.office.core.service.EmployeeService;
import by.koronatech.office.core.service.impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public GetEmployeeDTO create(@RequestBody CreateEmployeeDTO createEmployeeDTO) {
        return new GetEmployeeDTO(3L, "M", "M", false);
    }

    @GetMapping
    public List<GetEmployeeDTO> getByName(@RequestParam String name) {
        log.info("Get name = {}", name);
        return employeeService.getByName(name);
    }

    @GetMapping("/{id}")
    public GetEmployeeDTO getById(@PathVariable long id) {
        log.info("Get id = {}", id);
        return employeeService.getById(id);
    }

    @PutMapping("/{id}")
    public GetEmployeeDTO updateById(@PathVariable long id, @RequestBody CreateEmployeeDTO createEmployeeDTO) {
        log.info("Update id = {}", id);
        return employeeService.update(id, createEmployeeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        employeeService.delete(id);
        log.info("Delete id = {}", id);
    }
}

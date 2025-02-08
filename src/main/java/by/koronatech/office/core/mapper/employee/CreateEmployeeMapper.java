package by.koronatech.office.core.mapper.employee;


import by.koronatech.office.api.dto.CreateEmployeeDTO;
import by.koronatech.office.core.entity.EmployeeEntity;
import by.koronatech.office.core.mapper.BaseMapper;
import org.mapstruct.Mapper;


@Mapper(config = BaseMapper.class)
public interface CreateEmployeeMapper extends BaseMapper<EmployeeEntity, CreateEmployeeDTO> {
}

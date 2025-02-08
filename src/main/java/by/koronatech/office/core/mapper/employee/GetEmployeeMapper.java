package by.koronatech.office.core.mapper.employee;


import by.koronatech.office.api.dto.GetEmployeeDTO;
import by.koronatech.office.core.entity.EmployeeEntity;
import by.koronatech.office.core.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface GetEmployeeMapper extends BaseMapper<EmployeeEntity, GetEmployeeDTO> {
}

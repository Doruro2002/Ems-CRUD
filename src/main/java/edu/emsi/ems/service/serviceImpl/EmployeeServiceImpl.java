package edu.emsi.ems.service.serviceImpl;

import edu.emsi.ems.Exception.ResourceNotFound;
import edu.emsi.ems.dto.EmployeeDto;
import edu.emsi.ems.entity.Employee;
import edu.emsi.ems.mapper.EmployeeMapper;
import edu.emsi.ems.repository.EmployeeRepository;
import edu.emsi.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    /*Post*/
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee employeeSaved = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(employeeSaved);

    }

    /*Get*/
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId.intValue())
                .orElseThrow(() -> new ResourceNotFound("Employee does not exist"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }


    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {

        Employee employee = employeeRepository.findById(id.intValue())
                .orElseThrow(()-> new ResourceNotFound("Employee does not exist"));

        employee.setEmail(employeeDto.getEmail());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        Employee employeeUpdated =  employeeRepository.save(employee);
        EmployeeDto employeeDtoUpdated= EmployeeMapper.mapToEmployeeDto(employeeUpdated);
        return employeeDtoUpdated;
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id.intValue())
                .orElseThrow(()-> new ResourceNotFound("Employee does not exist"));

        employeeRepository.deleteById(id.intValue());
    }


}

package com.datien.cruds.service;

import com.datien.cruds.model.EmployeeDTO;
import com.datien.cruds.model.EmployeeResponseDTO;
import com.datien.cruds.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    public EmployeeService(EmployeeRepository repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public EmployeeResponseDTO addEmployee(
            EmployeeDTO employeeDTO
    ) {
        var employee = mapper.toEmployee(employeeDTO);
        var savedEmployee = repository.save(employee);
        return mapper.toEmployeeResponseDTO(savedEmployee);
    }

    public List<EmployeeResponseDTO> getAllEmployee() {
        return repository.findAll()
                .stream()
                .map(mapper::toEmployeeResponseDTO)
                .collect(Collectors.toList());
    }

    public EmployeeResponseDTO getEmployeeById(Integer id) {
        return repository.findById(id)
                .map(mapper::toEmployeeResponseDTO)
                .orElse(null);
    }

    public List<EmployeeResponseDTO> getEmployeeByName(String name) {
        return repository.findByFirstname(name)
                .stream()
                .map(mapper::toEmployeeResponseDTO)
                .collect(Collectors.toList());
    }

    public void deleteEmployee(Integer id) {
        repository.deleteById(id);
    }

}

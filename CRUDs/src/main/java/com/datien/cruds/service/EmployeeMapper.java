package com.datien.cruds.service;

import com.datien.cruds.model.Company;
import com.datien.cruds.model.Employee;
import com.datien.cruds.model.EmployeeDTO;
import com.datien.cruds.model.EmployeeResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    public Employee toEmployee(EmployeeDTO employeeDTO) {

        if(employeeDTO == null) {
            throw new NullPointerException("The employee DTO should not be null!");
        }

        var employee = new Employee();
        employee.setFirstname(employeeDTO.firstname());
        employee.setLastname(employeeDTO.lastname());
        employee.setEmail(employeeDTO.email());

        var company = new Company();
        company.setId(employeeDTO.companyId());

        employee.setCompany(company);
        return employee;
    }

    public EmployeeResponseDTO toEmployeeResponseDTO(Employee employee) {
        return new EmployeeResponseDTO(employee.getFirstname(), employee.getLastname(), employee.getEmail());
    }

}

package com.datien.cruds.service;

import com.datien.cruds.model.Employee;
import com.datien.cruds.model.EmployeeDTO;
import com.datien.cruds.model.EmployeeResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    private EmployeeMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new EmployeeMapper();
    }

    @Test
    public void shouldMapStudentDTOtoStudent() {
        // Given
        EmployeeDTO employeeDTO = new EmployeeDTO(
                "Kang",
                "Ha",
                "kh@gmail.com",
                52
        );

        // When
        Employee employee = mapper.toEmployee(employeeDTO);

        // Then
        assertEquals(employeeDTO.firstname(), employee.getFirstname());
        assertEquals(employeeDTO.lastname(), employee.getLastname());
        assertEquals(employeeDTO.email(), employee.getEmail());
        assertNotNull(employee.getCompany());
        assertEquals(employeeDTO.companyId(), employee.getCompany().getId());
    }

    @Test
    public void shouldThrowExceptionIfEmployeeIsNull() {
        var exp = assertThrows(NullPointerException.class, () -> mapper.toEmployee(null));
        assertEquals("The employee DTO should not be null!", exp.getMessage());
    }


    @Test
    public void shouldMapEmployeeToEmployeeResponseDTO() {

        Employee employee = new Employee(
                "Kang",
                "Ha",
                "kh@gmail.com",
                "0989982322"
        );

        EmployeeResponseDTO employeeResponseDTO = mapper.toEmployeeResponseDTO(employee);

        assertEquals(employeeResponseDTO.firstname(), employee.getFirstname());
        assertEquals(employeeResponseDTO.lastName(), employee.getLastname());
        assertEquals(employeeResponseDTO.email(), employee.getEmail());

    }

}
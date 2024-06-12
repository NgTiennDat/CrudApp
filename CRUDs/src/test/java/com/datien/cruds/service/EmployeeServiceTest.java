package com.datien.cruds.service;

import com.datien.cruds.model.Employee;
import com.datien.cruds.model.EmployeeDTO;
import com.datien.cruds.model.EmployeeResponseDTO;
import com.datien.cruds.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    // which service that we want to test
    @InjectMocks
    private EmployeeService service;

    // Declare the dependency
    @Mock
    private EmployeeRepository repository;
    @Mock
    private EmployeeMapper mapper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldSuccessfullyAddAnEmployee() {
        // Given
        EmployeeDTO employeeDTO = new EmployeeDTO(
                "Kang",
                "Ha",
                "kh@gmail.com",
                52
        );
        Employee employee = new Employee(
                "Kang",
                "Ha",
                "kh@gmail.com",
                "0929498823"
        );
        Employee savedEmployee = new Employee(
                "Kang",
                "Ha",
                "kh@gmail.com",
                "0929498823"
        );
        savedEmployee.setId(1);

        // Mock the calls
        when(mapper.toEmployee(employeeDTO))
                .thenReturn(employee);
        when(repository.save(employee))
                .thenReturn(savedEmployee);
        when(mapper.toEmployeeResponseDTO(savedEmployee))
                .thenReturn(new EmployeeResponseDTO(
                        "Kang",
                        "Ha",
                        "kh@gmail.com")
                );

        // When
        EmployeeResponseDTO employeeResponseDTO = service.addEmployee(employeeDTO);

        // Then
        assertEquals(employeeDTO.firstname(), employeeResponseDTO.firstname());
        assertEquals(employeeDTO.lastname(), employeeResponseDTO.lastName());
        assertEquals(employeeDTO.email(), employeeResponseDTO.email());

        verify(mapper, times(1))
                .toEmployee(employeeDTO);
        verify(repository, times(1))
                .save(employee);
        verify(mapper, times(1))
                .toEmployeeResponseDTO(savedEmployee);
    }

    @Test
    public void successfullyFindAllEmployee() {

        // Given
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(
                "Kang",
                "Ha",
                "kh@gmail.com",
                "0929498823"
        ));

        when(repository.findAll())
                .thenReturn(employees);
        when(mapper.toEmployeeResponseDTO(any(Employee.class)))
                .thenReturn(new EmployeeResponseDTO(
                        "Kang",
                        "Ha",
                        "kh@gmail.com"
                ));

        // when
        List<EmployeeResponseDTO> employeeDTOs = service.getAllEmployee();

        // then
        assertEquals(employees.size(), employeeDTOs.size());

        verify(repository, times(1)).findAll();
    }

    @Test
    public void successfullyFindEmployeeById() {
        Integer id = 1;
        Employee employee = new Employee(
                "Kang",
                "Ha",
                "kh@gmail.com",
                "0929498823"
        );

        when(repository.findById(id))
                .thenReturn(Optional.of(employee));
        when(mapper.toEmployeeResponseDTO(any(Employee.class)))
                .thenReturn(new EmployeeResponseDTO(
                        "Kang",
                        "Ha",
                        "kh@gmail.com"
                ));

        // when
        EmployeeResponseDTO employeeResponseDTO = service.getEmployeeById(id);

        // then
        assertEquals(employeeResponseDTO.firstname(), employee.getFirstname());
        assertEquals(employeeResponseDTO.lastName(), employee.getLastname());
        assertEquals(employeeResponseDTO.email(), employee.getEmail());

        verify(mapper, times(1)).toEmployeeResponseDTO(employee);
        verify(repository, times(1)).findById(id);

    }

}
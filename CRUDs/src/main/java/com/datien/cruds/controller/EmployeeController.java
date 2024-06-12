package com.datien.cruds.controller;

import com.datien.cruds.model.EmployeeDTO;
import com.datien.cruds.model.EmployeeResponseDTO;
import com.datien.cruds.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/employees")
    public EmployeeResponseDTO addEmployee(
            @Valid @RequestBody EmployeeDTO employeeDTO
    ) {
        return this.service.addEmployee(employeeDTO);
    }

    @GetMapping("/employees")
    public List<EmployeeResponseDTO> getAllEmployees() {
        return this.service.getAllEmployee();
    }

    @GetMapping("/employees/{employee-id}")
    public EmployeeResponseDTO getEmployeeById(
            @PathVariable("employee-id") Integer id
    ) {
        return this.service.getEmployeeById(id);
    }

    @GetMapping("/employees/search/{employee-name}")
    public List<EmployeeResponseDTO> getEmployeeByName(
            @PathVariable("employee-name") String firstname
    ) {
        return this.service.getEmployeeByName(firstname);
    }

    @DeleteMapping("/employees/{employee-id}")
    public void deleteEmployeeById(
            @PathVariable("employee-id") Integer id
    ) {
        this.service.deleteEmployee(id);
    }
}

package com.datien.cruds.service;

import com.datien.cruds.model.Company;
import com.datien.cruds.model.CompanyDTO;
import com.datien.cruds.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyMapper {

    public Company toCompany(CompanyDTO companyDTO) {


        var company = new Company();
        company.setName(companyDTO.name());
        company.setCountry(companyDTO.country());

        List<Employee> employees = new ArrayList<>();
        employees.addAll(companyDTO.employees());

        company.setEmployees(employees);

        return company;
    }

    public CompanyDTO toCompanyDTO(Company company) {
        return new CompanyDTO(company.getName(), company.getCountry(), company.getEmployees());
    }

}

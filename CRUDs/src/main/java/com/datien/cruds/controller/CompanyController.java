package com.datien.cruds.controller;

import com.datien.cruds.model.CompanyDTO;
import com.datien.cruds.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    private final CompanyService service;
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping("/companies")
    public CompanyDTO addCompany(
            @RequestBody CompanyDTO companyDTO
    ) {
        return this.service.addCompany(companyDTO);
    }

    @GetMapping("/companies")
    public List<CompanyDTO> getAllCompanies() {
        return this.service.getAllCompanies();
    }

    @GetMapping("/companies/{company-id}")
    public CompanyDTO findCompanyById(
            @PathVariable("company-id") Integer id
    ) {
        return this.service.findCompanyById(id);
    }

    @GetMapping("/companies/search1/{company-name}")
    public List<CompanyDTO> findCompanyByName(
            @PathVariable("company-name") String name
    ) {
        return this.service.findCompanyByName(name);
    }

    @GetMapping("/companies/search2/{company-country}")
    public List<CompanyDTO> findCompanyByCountry(
            @PathVariable("company-country") String country
    ) {
        return this.service.findCompanyByCountry(country);
    }

    @DeleteMapping("/companies/{company-id}")
    public void deleteCompany(
            @PathVariable("company-id") Integer id) {
        this.service.deleteCompanyById(id);
    }
}

package com.datien.cruds.service;

import com.datien.cruds.model.CompanyDTO;
import com.datien.cruds.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private final CompanyRepository repository;
    private final CompanyMapper mapper;

    public CompanyService(CompanyRepository repository, CompanyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CompanyDTO addCompany(CompanyDTO companyDTO) {
        var company = mapper.toCompany(companyDTO);
        repository.save(company);
        return companyDTO;
    }

    public List<CompanyDTO> getAllCompanies() {
        return repository.findAll()
                .stream()
                .map(mapper::toCompanyDTO)
                .collect(Collectors.toList());
    }

    public CompanyDTO findCompanyById(Integer id) {
        return repository.findById(id)
                .map(mapper::toCompanyDTO)
                .orElse(null);
    }

    public List<CompanyDTO> findCompanyByName(String name) {
        return repository.findCompaniesByName(name)
                .stream()
                .map(mapper::toCompanyDTO)
                .collect(Collectors.toList());
    }

    public List<CompanyDTO> findCompanyByCountry(String country) {
        return repository.findCompaniesByCountry(country)
                .stream()
                .map(mapper::toCompanyDTO)
                .collect(Collectors.toList());
    }

    public CompanyDTO updateCompany(Integer id, CompanyDTO companyDTO) {
        var company = repository.findById(id);
        return companyDTO;
    }

    public void deleteCompanyById(Integer id) {
        repository.deleteById(id);
    }

}

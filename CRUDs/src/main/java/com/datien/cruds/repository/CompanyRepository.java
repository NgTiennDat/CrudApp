package com.datien.cruds.repository;

import com.datien.cruds.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    List<Company> findCompaniesByName(String name);
    List<Company> findCompaniesByCountry(String country);
}

package com.datien.cruds.model;

import java.util.List;

public record CompanyDTO(
        String name,
        String country,
        List<Employee> employees
) {

}

package com.datien.cruds.service;

import com.datien.cruds.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceTest {

    @InjectMocks
    private CompanyService service;

    @Mock
    private CompanyRepository repository;
    @Mock
    private CompanyMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}
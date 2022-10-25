package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SearchFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);
    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    public void findCompanyByNameFragment(String nameFragment){
        LOGGER.info("searching for companies with \""+nameFragment+"\"...");
        List<Company> companies= companyDao.retrieveCompaniesByNameLike(nameFragment);
        if (companies.isEmpty()){
            LOGGER.error(SearchExceptions.ERR_NO_COMPANY_NAMES_FOUND);
        }
        LOGGER.info("list of companies found:");
        for (Company company :companies){
            LOGGER.info(company.getName());
        }
    }

    public void findEmployeeByNameFragment(String nameFragment){
        LOGGER.info("searching for employees with \""+nameFragment+"\"...");
        List<Employee> employees= employeeDao.retrieveEmployeesByNameFragment(nameFragment);
        if (employees.isEmpty()){
            LOGGER.error(SearchExceptions.ERR_NO_EMPLOYEE_NAMES_FOUND);
            return;
        }
        LOGGER.info("list of employees found:");
        for (Employee employee :employees){
            LOGGER.info(employee.getFirstname()+" "+employee.getLastname());
        }
    }

}

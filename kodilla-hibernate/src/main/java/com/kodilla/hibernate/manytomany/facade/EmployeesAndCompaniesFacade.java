package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesAndCompaniesFacade {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyDao companyDao;

    public List<Employee> findEmployeesWithPartOfLastname(String partOfLastname) {
        return employeeDao.retrieveEmployeesWithLastNameContaining(partOfLastname);
    }

    public List<Company> findComaniesWithPartOfName(String partOfName) {
        return companyDao.retrieveCompaniesWithNamesContaining(partOfName);
    }
}

package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EmployeesAndCompaniesFacadeTestSuite {

    @Autowired
    private EmployeesAndCompaniesFacade facade;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;
    Employee[] employees;
    Company[] companies;

    @Before
    public void prepareTestData() {
        employees = new Employee[5];
        employees[0] = new Employee("Whatever", "Abcdeftest");
        employees[1] = new Employee("Whatever", "Testabcdef");
        employees[2] = new Employee("Whatever", "Andanothertestlastname");
        employees[3] = new Employee("Whatever", "Heretesttoo");
        employees[4] = new Employee("Whatever", "X");

        companies = new Company[4];
        companies[0] = new Company("Test company name");
        companies[1] = new Company("Not a company test name");
        companies[2] = new Company("But this is a name test");
        companies[3] = new Company("XX");

        for (int i = 0; i < employees.length; i++) {
            companies[i % (companies.length - 1)].getEmployees().add(employees[i]);
        }
        Arrays.stream(companies)
                .forEach(companyDao::save);
    }

    @Test
    public void testFindEmployyesWithPartOfLastname() {
        // When
        String[] searchLastnameParts = {"test", "bcde", "x", "whatever"};
        int searchCount = searchLastnameParts.length;
        int[] foundEmployeesCount = new int[searchCount];
        for (int i = 0; i < searchCount; i++) {
            foundEmployeesCount[i] = facade.findEmployeesWithPartOfLastname(
                    searchLastnameParts[i]).size();
        }

        // Then
        int[] expectedFoundResults = {4, 2, 1, 0};
        for (int i = 0; i < searchCount; i++) {
            Assert.assertEquals(expectedFoundResults[i], foundEmployeesCount[i]);
        }
    }

    @Test
    public void testFindCompaniesWithPartOfName() {
        // When
        String[] searchNamesParts = {"test", "company","x", "whatever"};
        int searchCount = searchNamesParts.length;
        int[] foundCompaniesCount = new int[searchCount];
        for (int i = 0; i < searchCount; i++) {
            foundCompaniesCount[i] = facade.findComaniesWithPartOfName(
                    searchNamesParts[i]).size();
        }

        // Then
        int[] expectedFoundResults = {3, 2, 1, 0};
        for (int i = 0; i < searchCount; i++) {
            Assert.assertEquals(expectedFoundResults[i], foundCompaniesCount[i]);
        }
    }
}

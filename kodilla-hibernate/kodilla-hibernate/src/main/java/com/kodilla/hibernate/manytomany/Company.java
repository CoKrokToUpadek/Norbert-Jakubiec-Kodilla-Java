package com.kodilla.hibernate.manytomany;



import com.kodilla.hibernate.task.Task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Company.retrieveCompanyByFirstThreeCharacters",
                query = "SELECT * FROM COMPANIES WHERE LEFT(COMPANY_NAME,3) LIKE :THREELETTERS",
                resultClass = Company.class
        ),
        @NamedNativeQuery(
                name = "Company.retrieveCompaniesByNameLike",
                query = "SELECT * FROM COMPANIES WHERE COMPANY_NAME LIKE CONCAT('%',:NAMEFRAGMENT,'%')",
                resultClass = Company.class
        )

})
@Entity
@Table(name = "COMPANIES")
public class Company {

    private int id;
    private String name;

    private List<Employee> employees=new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }


    private void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }
}
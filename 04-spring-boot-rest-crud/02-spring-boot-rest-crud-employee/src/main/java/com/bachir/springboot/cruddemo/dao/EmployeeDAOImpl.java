package com.bachir.springboot.cruddemo.dao;

import com.bachir.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{


    //define field for entityManager
    private final EntityManager entityManager;

    //set up constructor injection

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result list
        List<Employee> employees;
        employees = theQuery.getResultList();

        //return the result
        return employees;
    }

    @Override
    public Employee findById(int theId){

        //Get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        //save the employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        //return the dbEmployee: update or added employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        //Find by id Employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //Delete Employee
        entityManager.remove(theEmployee);
    }
}

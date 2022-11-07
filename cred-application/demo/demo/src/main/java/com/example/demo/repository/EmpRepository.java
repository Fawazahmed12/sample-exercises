package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Repository

public class EmpRepository {

     public List<Employee> employee = new ArrayList<>();

    public List<Employee> getAll(){
        return employee;
    }

    public String add(Employee emp) {
         List<Employee> employeeList = employee;
         int maxEmployeeId = employeeList.stream().map(Employee::getEmployeeId).max(Integer :: compare).get();
         Employee newEmployee = new Employee(maxEmployeeId+1, emp.getEmployeeName(), emp.getEmployeeAge());

        employee.add(newEmployee);
        return "New Employee Details Added";
    }

    public String edit(Employee emp) {
        Stream<Employee> selectedEmp = employee.stream().filter(e -> e.getEmployeeId() == emp.getEmployeeId());
        selectedEmp.forEach(e -> {
            e.setEmployeeAge(emp.getEmployeeAge());
            e.setEmployeeId(emp.getEmployeeId());
            e.setEmployeeName(emp.getEmployeeName());
        });
        return "Employee " + emp.getEmployeeId() + " Data Modified Successfully";
    }

    public String delete(int employeeId) {
        employee.remove(employeeId-1);
        return "Employee " + (employeeId) + " is deleted Successfully.";
    }
}

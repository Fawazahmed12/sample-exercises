package com.example.demo.services;

import com.example.demo.entity.Employee;
import java.util.List;
import com.example.demo.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    @Autowired
    EmpRepository empRepository;

    public List<Employee> getAll(){
        return empRepository.getAll();
    }

    public String add(Employee emp) {
        return empRepository.add(emp);
    }

    public String edit(Employee emp) {
        return empRepository.edit(emp);
    }

    public String delete(int employeeId) {
        return empRepository.delete(employeeId);
    }
}

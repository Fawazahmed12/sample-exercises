package com.example.demo.controllers;

import com.example.demo.entity.Employee;
import java.util.List;
import com.example.demo.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class EmpController {

    @Autowired
    EmpService empService;

     @GetMapping("/get/all")
    public List<Employee>  getAll(){
        return  empService.getAll();
    }
    @PostMapping("/add")
    public String  add(@RequestBody Employee emp){
        return  empService.add(emp);
    }
    @PutMapping("/edit")
    public String  edit(@RequestBody Employee emp){
        return  empService.edit(emp);
    }
    @DeleteMapping("/delete")
    public String  delete(@RequestParam int employeeId){
        return  empService.delete(employeeId);
    }

}

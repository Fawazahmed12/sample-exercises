package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
    @Autowired
    EmpRepository empRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Employee e1 = new Employee(1, "John", 32);
        Employee e2 = new Employee(2, "Smith", 30);
        Employee e3 = new Employee(3, "Watson", 29);
        empRepository.employee.addAll(Arrays.asList(e1,e2,e3));
    }
}

package com.example.Thymeleaf_demo.Controllers;

import com.example.Thymeleaf_demo.Model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {

   private List<Employee> employees;

   @PostConstruct
    private void loadData(){
       Employee employee = new Employee(1, "John", "Smith", "JS@mail.com");
       Employee employee1 = new Employee(2, "Alla", "Frozen", "frozen@mail.com");
       Employee employee2 = new Employee(3, "Roma", "Iman", "Roman@mail.com");

       employees = new ArrayList<>();
       employees.add(employee);
       employees.add(employee1);
       employees.add(employee2);
   }
   @GetMapping("/list")
    public String listEmployees(Model model){
       model.addAttribute("employees", employees);
       return "hello";
   }
}

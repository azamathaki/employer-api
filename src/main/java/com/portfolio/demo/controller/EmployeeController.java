package com.portfolio.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.demo.model.User;
import com.portfolio.demo.model.WorkTable;
import com.portfolio.demo.service.EmployeeService;

@RestController
@RequestMapping("/home")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{username}")
    public User getEmployee(@PathVariable("username") String username){
        return employeeService.getEmployee(username);
    }

    @PostMapping("/employees")
    public String postEmployee(@RequestBody User employee){
        employeeService.createEmployee(employee);
        return "employee created successfully!";
    }

    @PutMapping("/employees/{username}/create/worktable")
    public String putWorkTable(@PathVariable("username") String username,
                                @RequestBody WorkTable workTable)
    {
        employeeService.createWorkTableForEmployee(username, workTable);
        return "worktable created successfully for employee !";
    }

    @DeleteMapping("/employees/{username}/delete/worktable")
    public String deleteWorkTable(@PathVariable("username") String username){
        employeeService.deleteWorkTableOfEmployee(username);
        return "worktable deletion was successfully!";
    }

}

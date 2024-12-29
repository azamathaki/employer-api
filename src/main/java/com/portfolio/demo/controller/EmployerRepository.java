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

import com.portfolio.demo.model.JobTable;
import com.portfolio.demo.model.User;
import com.portfolio.demo.service.EmployerService;

@RestController
@RequestMapping("/home")
public class EmployerRepository {
    

    @Autowired
    private EmployerService employerService;

    @GetMapping("/employers/{username}")
    public User getEmployer(@PathVariable("username") String username){
        return employerService.getEmployer(username);
    }

    @PostMapping("/employers")
    public String postEmployer(@RequestBody User employer){
        employerService.createEmployer(employer);
        return "employer created successfully!";
    }

    @PutMapping("/employers/{username}/create/jobtable")
    public String putJobTable(@PathVariable("username") String username, @RequestBody JobTable jobTable){
        employerService.createJobTableForEmployer(username, jobTable);
        return "jobtable created successfully for employer!";
    }

    @DeleteMapping("/employers/{username}/delete/jobtable")
    public String deleteJobTable(@PathVariable("username") String username){
        employerService.deleteJobTableOfEmployer(username);
        return "jobtable deleted successfully!";
    }



}

package com.portfolio.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.demo.model.User;
import com.portfolio.demo.model.WorkTable;
import com.portfolio.demo.repository.UserRepository;
import com.portfolio.demo.repository.WorkTableRepository;

@Service
public class EmployeeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkTableRepository workTableRepository;

    //creating an employee
    public void createEmployee(User employee) {
        if (employee != null){
            userRepository.save(employee);
        }
        System.out.println("employee object is might be null!");
    }

    //creating an work table for employee
    public void createWorkTableForEmployee(String username, WorkTable workTable){
        User employee = getEmployee(username);
        if (employee != null && workTable != null){
            employee.setWorkTable(workTable);
            workTable.setEmployee(employee);
            workTableRepository.save(workTable);
        }

        System.out.println("employee or worktable objects might be null");
    }

    // deleting a worktable of an employee
    public void deleteWorkTableOfEmployee(String username){
        User employee = getEmployee(username);
        if (employee != null && employee.getWorkTable() != null){
            WorkTable workTable = employee.getWorkTable();
            employee.setWorkTable(null);
            workTable.setEmployee(null);
            workTableRepository.delete(workTable);
        }
        System.out.println("emlployee or worktable might be null!");

    }

    public User getEmployee(String username){
        User employee = userRepository.findByUsername(username);
        if (employee != null){
            return employee;
        }

        return null;
    }

}

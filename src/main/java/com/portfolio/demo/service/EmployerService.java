package com.portfolio.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.demo.model.JobTable;
import com.portfolio.demo.model.User;
import com.portfolio.demo.model.myenums.UserIs;
import com.portfolio.demo.repository.JobTableRepository;
import com.portfolio.demo.repository.UserRepository;

@Service
public class EmployerService {
    
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private JobTableRepository jobTableRepository;


    public void createEmployer(User employer){
        if (employer != null){
            if (!usernameTaken(employer.getUsername())){
                userRepository.save(employer);
            }
        }

        System.out.println("employer object is might be null or username is taken!");
    }

    public void createJobTableForEmployer(String username, JobTable jobTable){
        User employer = getEmployer(username);
        if (employer != null && jobTable != null){
            if (employer.getJobTable() == null){
                employer.setJobTable(jobTable);
                jobTable.setEmployer(employer);
                jobTableRepository.save(jobTable);
            }
        }  

        System.out.println("user is not employer to create jobtable or something went wrong!");
    }


    public void deleteJobTableOfEmployer(String username){
        User employer = getEmployer(username);

        if (employer != null){
            JobTable jobTable  = employer.getJobTable();
            if (employer.getJobTable() != null){
                employer.setJobTable(null);
                jobTable.setEmployer(null);
                jobTableRepository.delete(jobTable);
            }
        }

        System.out.println("employer object migth be null or employer has no jobtable to delete!");

    }


    //get an employer
    public User getEmployer(String username){
        User employer = userRepository.findByUsername(username);
        if (employer != null){
            if (employer.getUserIs().equals(UserIs.EMPLOYER)){
                return employer;
            }
        }
        return null;
    }

    public boolean usernameTaken(String username){
        User user = getEmployer(username);

        if (user != null){
            return true;
        }else {
            return false;
        }
    }

}

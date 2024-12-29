package com.portfolio.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.demo.model.JobTable;

public interface JobTableRepository extends JpaRepository<JobTable, Long>{
    
}

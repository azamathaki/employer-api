package com.portfolio.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.demo.model.WorkTable;

public interface WorkTableRepository extends JpaRepository<WorkTable, Long> {
    
}

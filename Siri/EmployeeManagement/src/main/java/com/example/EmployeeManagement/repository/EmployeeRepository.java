package com.example.EmployeeManagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.example.EmployeeManagement.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository  extends JpaRepository<EmployeeEntity, Long>{

}

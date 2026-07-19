package com.police.DepartmentDetails.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.police.DepartmentDetails.model.DepartmentDetails;

@Repository
public interface DepartmentDao extends JpaRepository<DepartmentDetails, Integer> 
{
	List<DepartmentDetails> findByLevel(int level);
}